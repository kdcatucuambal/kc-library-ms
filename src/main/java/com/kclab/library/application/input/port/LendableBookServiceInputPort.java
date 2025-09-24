package com.kclab.library.application.input.port;

public interface LendableBookServiceInputPort {

    boolean execute(String bookId, String borrowerName);

}
