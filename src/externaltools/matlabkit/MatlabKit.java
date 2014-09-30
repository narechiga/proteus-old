package proteus.externaltools.matlabkit;

import java.io.*;
import java.util.*;


public class MatlabKit {
	// Everything in here is broken except for batch. Make sure your batch command has an exit command at the end.

	Process runningProcess;
	PrintWriter stdin;
	Scanner stdout;


	public void batch( String scriptName ) {
		try {
			ProcessBuilder builder = new ProcessBuilder("matlab",
								"-nojvm",
								"-nosplash",
								"< " + scriptName );
			builder.redirectErrorStream(true);
			Process process = builder.start();
			InputStream is = process.getInputStream();
			BufferedReader reader = new BufferedReader (new InputStreamReader(is));

			String line;
			while ((line = reader.readLine()) != null) {
				//if ( debugMode ) {
					System.out.println ("Matlab output: " + line);
				//}
			}


		} catch ( Exception e ) {
			e.printStackTrace();
		}

	}

	public void start() {
		try {
			ProcessBuilder builder = new ProcessBuilder("matlab",
								"-nojvm",
								"-nosplash" );
			builder.redirectErrorStream(true);
			Process runningProcess = builder.start();

			//this.stdout = new BufferedReader( new InputStreamReader( runningProcess.getInputStream() ) );
			this.stdout = new Scanner( runningProcess.getInputStream() );
			this.stdin = new PrintWriter( runningProcess.getOutputStream() );

			for ( int i = 0; i < 10; i ++ ) {
					System.out.println ("Matlab output: " +  stdout.nextLine() );
			}

		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public void command( String thisCommand ) {
		try {
			stdin.println( thisCommand );
			System.out.println("Issued a command, will this guy react?");

			for ( int i = 0; i < 1; i ++ ) {
					System.out.println ("Matlab output: " +  stdout.nextLine() );
			}

		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public void stop() {
		try {
			stdout.close();
			stdin.close();
			runningProcess.destroy();
		} catch ( Exception e ) {
			e.printStackTrace();
		}
	}

	public static void main ( String [] args ) {

		MatlabKit testKit = new MatlabKit();


		testKit.start();
		if ( testKit.stdin == null ) {
			System.out.println( "onoz!");
			System.exit(1);
		}
		testKit.command("fprintf('hello world, I am matlab')");
		System.out.println("Will run a command I guess");
		testKit.command("x = 6*7");
		System.out.println("Ran a command I guess");

		testKit.command("whos");
		testKit.stop();
		
	}



}
