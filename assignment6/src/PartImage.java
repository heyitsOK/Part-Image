import java.io.*;
import java.util.ArrayList;

public class PartImage {
    private boolean[][]	pixels;
    private boolean[][]	visited;
    private int	rows;
    private int	cols;
    private int perimeter;

    //Creates a new, blank PartImage with the given rows (r) and columns (c)
    public PartImage(int r, int c) {
        rows = r;
        cols = c;
        visited = new boolean[r][c];
        pixels = new boolean[r][c];
    }

    //Creates a new PartImage containing rw rows and cl columns
    //Initializes the 2D boolean pixel array based on the provided byte data
    //A 0 in the byte data is treated as false, a 1 is treated as true
    public PartImage(int rw, int cl, byte[][] data) {
        this(rw,cl);
        for (int r=0; r<10; r++) {
            for (int c=0; c<10; c++) {
                if (data[r][c] == 1)
                    pixels[r][c] = true;
                else
                    pixels[r][c]= false;
            }
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }
    public boolean getPixel(int r, int c) { return pixels[r][c]; }

    public void print() {
        for (int i = 0; i < pixels.length; i++) {
            String s = "";
            for (int j = 0; j < pixels[i].length; j++) {
                if (pixels[i][j]) {
                    s += "*";
                }
                else {
                    s+= "-";
                }
            }
            System.out.println(s);
        }
    }

    public Point2D findStart() {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                if (pixels[i][j]) {
                    Point2D point = new Point2D(i, j);
                    return point;
                }
            }
        }
        return null;
    }

    public int partSize() {
        int count = 0;
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                if (pixels[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void expandFrom(int r, int c) {
        if (r >= pixels.length || r < 0) {
            return;
        }
        else if (c >= pixels[r].length || c < 0) {
            return;
        }
        if (pixels[r][c] == false) {
            return;
        }
        pixels[r][c] = false;
        expandFrom(r+1, c);
        expandFrom(r, c+1);
        expandFrom(r-1, c);
        expandFrom(r, c-1);

    }

    private int perimeterOf(int r, int c) {
        if (r >= pixels.length || r < 0) {return 0;}
        else if (c >= pixels[r].length || c < 0) {return 0;}
        if (pixels[r][c] == false) {return 0;}
        if (visited[r][c]) {
            return 0;
        }
        visited[r][c] = true;
        if (r == 0 || !(pixels [r-1][c])) {perimeter++;}
        if (r == pixels.length-1 || !(pixels[r+1][c])) {perimeter++;}
        if (c == 0 || !(pixels[r][c-1])) {perimeter++;}
        if (c == pixels[r].length-1 || !(pixels[r][c+1])) {perimeter++;}
        perimeterOf(r-1, c);
        perimeterOf(r+1, c);
        perimeterOf(r, c-1);
        perimeterOf(r, c+1);
        return perimeter;
    }

    public boolean isBroken(){
        Point2D p = findStart();
        expandFrom((int)p.getX(), (int)p.getY());
        return (partSize() != 0);
    }

    public int perimeter() {
        Point2D p = findStart();
        return perimeterOf((int)p.getX(), (int)p.getY());
    }

    public int countPieces(){
        int count = 0;
        while (partSize() > 0) {
            Point2D start = findStart();
            expandFrom(start.getX(), start.getY());
            count++;
        }
        return count;
    }

    public static PartImage readFromFile(String fileName) throws InvalidPartImageException{
        try {
            PartImage part;
            File f = new File(fileName);
            BufferedReader in;
            in = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            int numBytes = ((int) f.length());
            String line = in.readLine();
            int cols = line.length();
            int rows = (numBytes+2)/(cols+2);
            cols = (cols+1)/2;
            byte[][] data = new byte[rows][cols];
            for (int i = 0; i < data.length; i++){
                String[] r = line.split(",");
                if (r.length != cols) {
                    throw new InvalidPartImageException(fileName);
                }
                for (int j = 0; j < data[i].length; j++) {
                    if (r[j].equals("1")) {
                        data[i][j] = 1;
                    }
                    else if(!(r[j].equals("0"))) {
                        throw new InvalidPartImageException(fileName);
                    }
                }
                line = in.readLine();
            }
            part = new PartImage(rows, cols, data);
            in.close();
            return part;
        }
        catch (FileNotFoundException e) {
            return null;
        }
        catch (IOException e) {
            return null;
        }
    }
}