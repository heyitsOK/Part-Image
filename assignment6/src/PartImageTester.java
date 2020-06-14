public class PartImageTester {
    public static void main(String[] args) {
        PartImage piA = null;
        PartImage piB = null;
        PartImage piC = null;
        PartImage piD = null;

        try {
            piA = PartImage.readFromFile("exampleA.txt");
            piB = PartImage.readFromFile("exampleB.txt");
            piC = PartImage.readFromFile("exampleC.txt");
            piD = PartImage.readFromFile("exampleD.txt");
        } catch(InvalidPartImageException e) {
            System.out.println("Invalid image data in file: " + e.getFilename());
        }

        try {
            System.out.println("\nPart A:");
            System.out.println("	starts at: " + PartImage.readFromFile("exampleA.txt").findStart());
            System.out.println("	size:	" + PartImage.readFromFile("exampleA.txt").partSize());
            System.out.println("	broken:	" + PartImage.readFromFile("exampleA.txt").isBroken());
            System.out.println("	perimeter: " + PartImage.readFromFile("exampleA.txt").perimeter() + "\n");
            System.out.println("	# pieces: " + PartImage.readFromFile("exampleA.txt").countPieces() + "\n");
            piA.print();
        } catch(InvalidPartImageException e) {
            System.out.println("Invalid image data in file: " + e.getFilename());
        }

        try {
            System.out.println("\nPart B:");
            System.out.println("	starts at: " + PartImage.readFromFile("exampleB.txt").findStart());
            System.out.println("	size:	" + PartImage.readFromFile("exampleB.txt").partSize());
            System.out.println("	broken:	" + PartImage.readFromFile("exampleB.txt").isBroken());
            System.out.println("	perimeter: " + PartImage.readFromFile("exampleB.txt").perimeter() + "\n");
            System.out.println("	# pieces: " + PartImage.readFromFile("exampleB.txt").countPieces() + "\n");
            piB.print();
        } catch(InvalidPartImageException e) {
            System.out.println("Invalid image data in file: " + e.getFilename());
        }
        try {
            System.out.println("\nPart C:");
            System.out.println("	starts at: " + PartImage.readFromFile("exampleC.txt").findStart());
            System.out.println("	size:	" + PartImage.readFromFile("exampleC.txt").partSize());
            System.out.println("	broken:	" + PartImage.readFromFile("exampleC.txt").isBroken());
            System.out.println("	perimeter: " + PartImage.readFromFile("exampleC.txt").perimeter() + "\n");
            System.out.println("	# pieces: " + PartImage.readFromFile("exampleC.txt").countPieces() + "\n");
            piC.print();
        } catch(InvalidPartImageException e) {
            System.out.println("Invalid image data in file: " + e.getFilename());
        }

        try {
            System.out.println("\nPart D:");
            System.out.println("	starts at: " + PartImage.readFromFile("exampleD.txt").findStart());
            System.out.println("	size:	" + PartImage.readFromFile("exampleD.txt").partSize());
            System.out.println("	broken:	" + PartImage.readFromFile("exampleD.txt").isBroken());
            System.out.println("	perimeter: " + PartImage.readFromFile("exampleD.txt").perimeter() + "\n");
            System.out.println("	# pieces: " + PartImage.readFromFile("exampleD.txt").countPieces() + "\n");
            piD.print();
        } catch(InvalidPartImageException e) {
            System.out.println("Invalid image data in file: " + e.getFilename());
        }

        try {
            System.out.println("Trying part E - should cause an InvalidPartImageException...");
            PartImage piE = PartImage.readFromFile("exampleE.txt");
            System.out.println("If you see this, the exception was not thrown.");
        } catch(InvalidPartImageException e) {
            System.out.println("Invalid image data in file: " + e.getFilename());
        }

        try {
            System.out.println("Trying part F - should cause an InvalidPartImageException...");
            PartImage piF = PartImage.readFromFile("exampleF.txt");
            System.out.println("If you see this, the exception was not thrown.");
        }catch(InvalidPartImageException e) {
            System.out.println("Invalid image data in file: " + e.getFilename());
        }

        try {
            System.out.println("Trying part G - should be null because file does not exist: " + PartImage.readFromFile("exampleG.txt"));
        }catch(InvalidPartImageException e) {
            System.out.println("Invalid image data in file: " + e.getFilename());
        }
    }
}
