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
	
// what kind of operations do i need?
// copy: copy an existing dLStructure into another cell, with another name--use clone method
// 	copy newStructure = existingStructure
// 		just call existingStructure.clone(), and add it to the hash set. Of the same
// 		class as the one that was cloned.
//
// spawn: generate a new instance, overwriting any that may already exist
// 	spawn RealVariable aVariable "a"
// 		>Does this mean that I should create a new constructor, for everybody, so that they can
// 		take string as input for their constructor?
// 		> Probably the right thing to do is to omit the type declaration and call the parser on the string
// 		that specified the structure, i.e.
// 			spawn # aNumber # 34
//
//
}
