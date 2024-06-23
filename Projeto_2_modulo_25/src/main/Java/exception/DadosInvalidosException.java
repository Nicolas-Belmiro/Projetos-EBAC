package main.Java.exception;

public class DadosInvalidosException     extends    Exception {
        private static final long serialVersionUID = 1L;

	public DadosInvalidosException(String msg) {
            this(msg, null);
        }

    public DadosInvalidosException(String msg, Throwable e) {
            super(msg, e);
        }
    }
