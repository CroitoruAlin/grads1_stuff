package com.endava.concurrency._1.threadcreation.runnable;

public class PrintInput implements Runnable {

	private final String messageToPrint;

	public PrintInput(final String messageToPrint) {
		this.messageToPrint = messageToPrint;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		System.out.println(messageToPrint);
	}

	public static void main(final String[] args) {
		// single thread creation
		final Thread worker = new Thread(new PrintInput("i'm alive!"));
		worker.start();
	}

}
