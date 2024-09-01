package main.java.exeptions;

public class DAOException extends Throwable {


    private static final long serialVersionUID = 7054379063290825137L;

    public DAOException(String msg, Exception ex) {
        super(msg, ex);

    }
}