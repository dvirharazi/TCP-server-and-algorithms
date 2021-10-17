import java.io.*;
import java.net.Socket;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket =new Socket("127.0.0.1",8010);
        System.out.println("client: Created Socket");

        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream toServer=new ObjectOutputStream(outputStream); //write to server
        ObjectInputStream fromServer=new ObjectInputStream(inputStream);  //read from server

        // sending #1 matrix

        int[][] source = {
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0},
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1}
        };

        Matrix mat1 = new Matrix();
        Matrix mat2 = new Matrix();
        Scanner scan  = new Scanner(System.in);
        System.out.println("enter row: ");
        int row  = scan.nextInt();
        System.out.println("enter column: ");
        int col = scan.nextInt();
        while(row >50 || col>50){
            System.out.println("your rows and columns need to be limited until 50, try again...");
            System.out.println("enter row: ");
            row  = scan.nextInt();
            System.out.println("enter column: ");
            col = scan.nextInt();
        }
        int[][] matZeroOne = mat1.MatrixZeroOneRandom(row,col);
        int[][] matWeight = mat2.MatrixWeightRandom(row,col);


        //--------------------------------------------------------------------------------------------------------------

        //send "matrix" command then write 2d array to socket
        toServer.writeObject("matrix");
        toServer.writeObject(matZeroOne);

        //--------------------------------------------------------------------------------------------------------------

        toServer.writeObject("mission-one");
        toServer.writeObject(matZeroOne);

        List<Set<Index>> scc =
            new ArrayList((List<Index>) fromServer.readObject());
        System.out.println("from client - all SCC Indices are:  "+ scc);

        //--------------------------------------------------------------------------------------------------------------

        toServer.writeObject("mission-two");
        toServer.writeObject(source);
        toServer.writeObject(new Index(0,0));
        toServer.writeObject(new Index(2,1));

        List<ArrayList<Node>> shortestPaths =
            new ArrayList((ArrayList<Node>) fromServer.readObject());
        System.out.println("from client - all shortestPath Indices are:  "+ shortestPaths);

        //--------------------------------------------------------------------------------------------------------------

        toServer.writeObject("mission-three");
        toServer.writeObject(matZeroOne);

        int numberOfSubmarine = (int) fromServer.readObject();
        System.out.println("from client - number of submarine are:  "+ numberOfSubmarine);

        //--------------------------------------------------------------------------------------------------------------

        toServer.writeObject("mission-four");
        toServer.writeObject(matWeight);
        toServer.writeObject(new Index(1,0));
        toServer.writeObject(new Index(1,2));

        List<ArrayList<Node>> easyPaths =
            new ArrayList((ArrayList<Node>) fromServer.readObject());
        System.out.println("from client - all easyPaths Indices are:  "+ easyPaths);

        //--------------------------------------------------------------------------------------------------------------

        toServer.writeObject("stop");

        System.out.println("client: Close all streams");
        fromServer.close();
        toServer.close();
        socket.close();
        System.out.println("client: Closed operational socket");
    }
}