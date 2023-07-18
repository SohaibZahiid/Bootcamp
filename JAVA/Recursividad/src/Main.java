
public class Main {

	public static void main(String[] args) {
		String[] techs = {"Markdown", "Regexp", "HTML", "CSS", "JS", "SQL" ,"Java"};

		// 1-- 
//		recursiveFunc(techs, 0);
		
		// 2--
//		recursiveFuncStop(techs, 0);
		
		// 4--
		System.out.println(revertStr("supercalifragilisticoespialidoso"));
		
	}
	
	private static String revertStr(String str) {
		
		if(str.isEmpty() ) {
			return str;
		}
		
		return revertStr(str.substring(1)) + str.charAt(0);
	}

	public static void recursiveFunc(String[] techs, int index) {
		if(techs.length <= index) {
			return;
		}
		
		System.out.println(techs[index]);
		
		index++;
		
		recursiveFunc(techs, index);
		
	}

	public static void recursiveFuncStop(String[] techs, int index) {
		if(techs.length <= index || techs[index].equalsIgnoreCase("HTML")) {
			return;
		}
		
		System.out.println(techs[index]);
		
		index++;
		
		recursiveFuncStop(techs, index);
		
	}
}
