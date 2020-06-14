public class InvalidPartImageException extends Exception {
    private String filename;

    public InvalidPartImageException(String filename){
            this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }
}
