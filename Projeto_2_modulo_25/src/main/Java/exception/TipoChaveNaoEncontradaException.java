package main.Java.exception;

public class TipoChaveNaoEncontradaException extends
      Exception{
        private static final long serialVersionUID = 1L;

	public TipoChaveNaoEncontradaException(String msg) {
            this(msg, null);
        }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
            super(msg, e);
        }

    }
