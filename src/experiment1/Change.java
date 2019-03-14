package experiment1;

public class Change {
	private static String list[] = {"A","B","C","D","E","F","G","H",
            "I","J","K","L","M","N","O","P",
            "Q","R","S","T","U","V","W","X","Y","Z"};
	
	public String encrypt(String text, int k) {
		String[] plain = text.split("");
		String cipher = "";
		
		for(int i=0; i<plain.length; i++) {
			for(int j=0; j<26; j++) {
				if(plain[i].toUpperCase().equals(list[j])) {
					cipher += list[(j+k)%26];
				}
			}
		}
		return cipher;
	}
	
	public String decrypt(String text, int k) {
		String[] cipher = text.split("");
		String plain = "";
		for(int i=0; i<cipher.length; i++) {
			for(int j=0; j<26; j++) {
				if(cipher[i].toUpperCase().equals(list[j])) {
					plain += list[(j+26-k)%26];
				}
			}
		}
		return plain;
	}
	public static void main(String[] args) {
		Change key = new Change();
		String text = "Why so serious";
		String cipher = key.encrypt(text, 4);
		String plain = key.decrypt(cipher, 4);
		System.out.println(cipher);
		System.out.println(plain);
	}
}
