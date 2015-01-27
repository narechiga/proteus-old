package proteus.externaltools;


public abstract class ScriptingKit {

	// This is broken!

	protected int runningProcess;
	protected PrintWriter stdin;
	protected Scanner stdout;

	public abstract void batch( String scriptName );
	public abstract void start();
	public abstract void command( String thisCommand );
	public abstract void stop();

}


