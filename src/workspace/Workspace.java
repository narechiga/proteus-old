package proteus.workspace;

import proteus.dl.syntax.*;
import proteus.dl.parser.*;

public class Workspace {

	HashMap<String, dLStructure> items;
	HashMap<String, String> types;

	public Workspace() {
		items = new HashMap<String, dLStructure>();
		types = new HashMap<String, String>();
	}

// List all the members, akin to Matlab's "whos" command
	public HashMap<String, dLStructure> getItems() {
		return items;
	}
	
	public HashMap<String, String> getTypes() {
		return types;
	}

// Make a new member
	
// Manipulate a member
	
}
