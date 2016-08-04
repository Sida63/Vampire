package cn.edu.xjtu.se.vampire.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Random;

import cn.edu.xjtu.se.vampire.hibernate.entity.User;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyFilter;

public class Utilities {

	private static final int ROUNDS = 4;

	final static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	// ¼ÓËÙ×Ö·û´®²úÉú
	private static final char CODES[] = {
	/* ´óĞ´×ÖÄ¸0~25 */
	'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			/* Ğ¡Ğ´×ÖÄ¸26~51 */
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			/* Êı×Ö52~61 */
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			/* ÌØÊâ×Ö·û62~94 */
			'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-',
			'.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^',
			'_', '`', '{', '|', '}', '~', '' };

	// ÖĞÎÄĞÕÃûÉú³ÉÊ¹ÓÃÊı¾İ
	private static final String Xing = "ÕÔÇ®ËïÀîÖÜÎâÖ£Íõ·ë³ÂñÒÎÀ½¯Éòº«ÑîÖìÇØÓÈĞíºÎÂÀÊ©ÕÅ¿×²ÜÑÏ»ª½ğÎºÌÕ½ªÆİĞ»×ŞÓ÷°ØË®ñ¼ÕÂÔÆËÕÅË¸ğŞÉ·¶ÅíÀÉÂ³Î¤²ıÂíÃç·ï»¨·½ÓáÈÎÔ¬ÁøÛº±«Ê·ÌÆ·ÑÁ®á¯Ñ¦À×ºØÄßÌÀëøÒóÂŞ±ÏºÂÚù°²³£ÀÖÓÚÊ±¸µÆ¤±åÆë¿µÎéÓàÔª²·¹ËÃÏÆ½»ÆºÍÄÂÏôÒüÒ¦ÉÛÕ¿ÍôÆîÃ«ÓíµÒÃ×±´Ã÷ê°¼Æ·ü³É´÷Ì¸ËÎÃ©ÅÓĞÜ¼ÍÊæÇüÏî×£¶­Áº¶ÅÈîÀ¶ãÉÏ¯¼¾ÂéÇ¿¼ÖÂ·Â¦Î£½­Í¯ÑÕ¹ùÃ·Ê¢ÁÖµóÖÓĞìÇñÂæ¸ßÏÄ²ÌÌï·®ºúÁè»ôÓİÍòÖ§¿ÂêÃ¹ÜÂ¬Äª¿Â·¿ôÃçÑ¸É½âÓ¦×Ú¶¡ĞûêÚµËÓôµ¥º¼ºé°üÖî×óÊ¯´Ş¼ªÅ¥¹¨³ÌïúĞÏ»¬ÅáÂ½ÈÙÎÌÜ÷ÑòÓÚ»İÕçÇú¼Ò·âÜÇôà´¢½ù¼³ÚûÃÓËÉ¾®¶Î¸»Î×ÎÚ½¹°Í¹­ÄÁÚóÉ½¹È³µºî";
	private static final String Ming = "¼ÎÕÜ¿¡²©åûÀÖ¼Ñº­³¿ÓîâùÔó×Ó·²ÔÃË¼ŞÈÒÀºÆãüÍ®±ùæÂ¿­ÒÁä¿´¾Ò»½àÈãÇå¼ªÔ´Ô¨ºÍº¯æ¥ÒËÔÆç÷ÁâĞûÒÊ½¡ĞÅĞÀ¿ÉÑóÆ¼ÈÙéÅº¬ÓÓÃ÷ĞÛÃ·Ö¥Ó¢ÒåÊçÇäÇ¬Òà·Òİæê»Ü¿Ììá°ê¿Ò¢ºèÆåÁÕ×Î¾êå·ÁÖÇÇçùØ©°²ÒãÁèÈªÀ¤ÇçÖñæµæ¼ºãÓåİ¼ÁäºëÅåÑ«ÄşÔª¶°Ó¯½­¾¸×¿´º½úÒİãäÙ»êÅç²º£Ê¥³ĞÃñÖÇÌÄÈİÁç·åîÚä¸ĞÂÀò¶÷ÓğÄİĞñÎ¬¼ÒÌ©Ê«ÑèÑô±òÊéÜßººÎµ¼áÒğÔÅ†´¹úÂØÁ¼Ô£ÈÚÖÂ¸»µÂÒ×ºç¸ÙóŞÆæÆ½İíÕæÖ®»ËèëÃµÇ¿´åÅæãë·æÑåÑÓÍ¥Ï¼¹ÚÒæÛ¿¾ûŞ±Í¤å«»¸¶«äŞÌñèª´ïÈºÜçÏÈÖŞÒçéª»ùĞùÔÂÃÀĞÄÜøµ¤É­Ñ§ÎÄ";

	// Ëæ»úÊıÉú³ÉÆ÷
	private static final Random RANDOM = new Random();

	/**
	 * Return the first element in the iterable container.
	 * 
	 * @param s
	 *            the container.
	 * @return null if the container is empty or null.
	 */
	static public <T> T first(Iterable<T> s) {
		T one = null;
		Iterator<T> it = s.iterator();
		if (s != null && it.hasNext()) {
			one = it.next();
		}
		return one;
	}
	
	static public String toJSONStringFiltered(Object obj) {
		JSONSerializer serializer = new JSONSerializer();
		serializer.getPropertyFilters().add(new PropertyFilter() {
			
			@Override
			public boolean apply(Object object, String name, Object value) {
				if(object instanceof User)
					if(name.equals("password") || name.equals("salt"))
						return false;
				return true;
			}
		});
		serializer.write(obj);
		return serializer.getWriter().toString();
	}
	
	/**
	 * Parse id from string. <br>
	 * Use this method for unsigned id parsing.
	 * @param str
	 * @return -1 if there is any exception throwed during the parsing.
	 */
	static public int parseId(String str) {
		int id = -1;
		try {
			id = Integer.parseInt(str);
		} catch (Exception ex) {}
		return id;
	}

	/**
	 * Generate md5 sum of given str.
	 * 
	 * @param str
	 * @return md5sum in lower case
	 */
	static public String generateMd5sum(String str) {
		try {
			byte[] strTemp = str.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int mdlen = md.length;
			char res[] = new char[mdlen * 2];
			for (int i = 0, k = 0; i < mdlen; i++) {
				byte byte0 = md[i];
				res[k++] = hexDigits[byte0 >>> 4 & 0xf];
				res[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(res);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Generate secured password using salt. Utilities.ROUNDS turns is used.
	 * 
	 * @param passwd
	 *            plain password
	 * @param salt
	 *            salt used to secure
	 * @return the generated secured password
	 */
	static public String generateSecPass(String passwd, String salt) {
		return generateSecPass(passwd, salt, Utilities.ROUNDS);
	}

	/**
	 * Generate secured password using salt.
	 * 
	 * @param passwd
	 *            plain password
	 * @param salt
	 *            salt used to secure
	 * @param turn
	 *            rounds to generate
	 * @return the generated secured password
	 */
	static public String generateSecPass(String passwd, String salt, int turn) {
		String str = passwd + salt;
		for (int i = 0; i != turn; i++)
			str = generateMd5sum(str + salt);
		return str;
	}

	/**
	 * Generate where statement in sql from given constrains. You can just
	 * append the return value to your sql statements.
	 * 
	 * @param key
	 *            key/value pairs splited by ';'. key/value pairs are strings in
	 *            format that "key=value"
	 * @return Generated statement.
	 */
	static public String generateWhereStatement(String key) {
		return generateWhereStatement(key, "");
	}

	/**
	 * Generate where statement in hql from given constrains. You can just
	 * append the return value to your hql statements.
	 * 
	 * @param key
	 *            key/value pairs splited by ';'. key/value pairs are strings in
	 *            format that "key=value"
	 * @return Generated statement.
	 */
	static public String generateWhereStatementH(String key) {
		return generateWhereStatement(key, "model");
	}

	static public String generateWhereStatement(String key, String tablename) {
		StringBuilder sb = new StringBuilder();
		sb.append(" where ");
		key = key.trim();
		if (!key.isEmpty()) {
			String[] constrains = key.split(";");
			for (int i = 0; i != constrains.length; i++) {
				String[] tmp = constrains[i].split("=");
				if (tmp.length != 2)
					continue;

				if (tablename != null && !tablename.isEmpty()
						&& tmp[0].equalsIgnoreCase("ID"))
					tmp[0] = tablename.concat(".").concat(tmp[0]);

				sb.append(tmp[0]).append("=").append("'").append(tmp[1])
						.append("'");

				if (i != constrains.length - 1)
					sb.append(" and ");
			}
		} else {
			sb.append("true");
		}

		sb.append(" ");
		return sb.toString();
	}

	/**
	 * Generate Codes: to generate random string include up or low case and
	 * number for given length. ±¾·½·¨ÊÊÓÃÓÚÉú³ÉÖ¸¶¨´óĞ¡µÄËæ»ú×Ö·û´®£¬º¬´óĞ¡Ğ´×Ö·ûÒÔ¼°Êı×Ö
	 * 
	 * @param length
	 *            the length you want
	 * @return the random string
	 */
	public static String generateCodes(int length) {
		StringBuffer jpsb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			jpsb.append(Utilities.CODES[Utilities.RANDOM.nextInt(62)]);
		}
		return jpsb.toString();
	}

	/**
	 * Generate salt: you know that Éî³ÉÑÒ£¬ÓÃÓÚ¼ÓÃÜ
	 * 
	 * @return ÑÎ
	 */
	public static String generateSalt() {
		return Utilities.generateCodes(16);
	}

	/**
	 * Generate Name: to generate name in Chinese Éú³ÉÖĞÎÄĞÕÃû
	 * 
	 * @param name3
	 *            is the name is 3 words? true : 3 ; flase : 2
	 * @return
	 */
	public static String generateName(boolean name3) {
		StringBuffer jpsb = new StringBuffer();
		jpsb.append(Xing.charAt(Utilities.RANDOM.nextInt(Xing.length())));
		jpsb.append(Ming.charAt(Utilities.RANDOM.nextInt(Ming.length())));
		if (name3) {
			jpsb.append(Ming.charAt(Utilities.RANDOM.nextInt(Ming.length())));
		}
		return jpsb.toString();
	}

	/**
	 * Generate 3-word-name in Chinese
	 * 
	 * @return
	 */
	public static String generateName3() {
		return Utilities.generateName(true);
	}

	/**
	 * Generate 2-word-name in Chinese
	 * 
	 * @return
	 */
	public static String generateName2() {
		return Utilities.generateName(false);
	}

	public static String generatePhoneNumber() {
		StringBuffer jpsb = new StringBuffer();
		jpsb.append(1).append(
				Utilities.RANDOM.nextBoolean() ? 3 : Utilities.RANDOM
						.nextBoolean() ? 5 : 8);
		for (int i = 0; i < 9; i++) {
			jpsb.append(Utilities.RANDOM.nextInt(10));
		}
		return jpsb.toString();
	}

	/**
	 * Return a string formated to show all properties of the object.
	 * Still has problems here, the lazy inilization is not handled, and will cause exception.
	 * @param obj
	 * @return
	 */
	public static String toFormatString(Object obj) {
		if (obj == null)
			return "null";
		
		StringBuilder sb = new StringBuilder();
		sb.append(obj.getClass().getName()).append("\n");
		
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field field : fields) {
			if(Modifier.isStatic(field.getModifiers()))
					continue;
			
			boolean iscollection = false;
			for (Class<?> clasz : field.getType().getInterfaces()) {
				if (clasz.getSimpleName().startsWith("Collection")) {
					iscollection = true;
					break;
				}
			}
			
			sb.append("\t").append(field.getName()).append(" : ");
			try {
				String getmethod = "get" + firstLetterToUpper(field.getName());
				Object temobj = invokeMethod(obj, getmethod, null);
				if (iscollection) {
					sb.append("size is ").append(invokeMethod(temobj, "size", null));
				} else {
					sb.append(temobj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			sb.append("\n");
		}

		return sb.toString();
	}

	static public Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {

		@SuppressWarnings("rawtypes")
		Class[] argsClass = null;
		if(null != args) {
			argsClass = new Class[args.length];
			for (int i = 0, j = args.length; i < j; i++) {
				argsClass[i] = args[i].getClass();
			}
		}
		Method method = owner.getClass().getMethod(methodName, argsClass);

		return method.invoke(owner, args);
	}

	static public String firstLetterToUpper(String str) {
		char[] array = str.toCharArray();
		if(Character.isLowerCase(array[0]))
			array[0] -= 32;
		return String.valueOf(array);
	}
}
