package modulo2;

public class VotingKey {
	
	public static String getImgPrefix(KeyEnum key) {
		String result;
		switch(key) {
		case D0:
			result = "0";
			break;
		case D1:
			result = "1";
			break;
		case D2:
			result = "2";
			break;
		case D3:
			result = "3";
			break;
		case D4:
			result = "4";
			break;
		case D5:
			result = "5";
			break;
		case D6:
			result = "6";
			break;
		case D7:
			result = "7";
			break;
		case D8:
			result = "8";
			break;
		case D9:
			result = "9";
			break;
		case CGREEN:
			result = "confirma";
			break;
		case CRED:
			result = "corrige";
			break;
		case CWHITE:
			result = "branco";
			break;
		default:
			result = "";
		}
		return result;
	}
}
