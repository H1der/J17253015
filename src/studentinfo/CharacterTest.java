package studentinfo;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {
	public void testWhitespace(){
		System.out.println(Character.isWhitespace('c'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isWhitespace('\n'));
        System.out.println(Character.isWhitespace('\t'));
	}
}
