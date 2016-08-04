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

	// �����ַ�������
	private static final char CODES[] = {
	/* ��д��ĸ0~25 */
	'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
			/* Сд��ĸ26~51 */
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			/* ����52~61 */
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			/* �����ַ�62~94 */
			'!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-',
			'.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^',
			'_', '`', '{', '|', '}', '~', '' };

	// ������������ʹ������
	private static final String Xing = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧���ù�¬Ī�·����Ѹɽ�Ӧ�ڶ����ڵ��������������ʯ�޼�ť�������ϻ���½���������ڻ������ҷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ���";
	private static final String Ming = "���ܿ������ּѺ����������ӷ���˼��������ͮ���¿���俴�һ�����弪ԴԨ�ͺ�������������ʽ���������Ƽ���ź�������÷֥Ӣ������Ǭ������ܿ����Ң�������ξ��������ة������Ȫ�������漺���ݼ�����ѫ��Ԫ��ӯ����׿��������ٻ��粺�ʥ���������������������������ά��̩ʫ���������ߺ�ε�����ņ�������ԣ���¸����׺������ƽ����֮����õǿ�����������ͥϼ����ۿ��ޱͤ嫻�������誴�Ⱥ��������骻�������������ɭѧ��";

	// �����������
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
	 * number for given length. ����������������ָ����С������ַ���������Сд�ַ��Լ�����
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
	 * Generate salt: you know that ����ң����ڼ���
	 * 
	 * @return ��
	 */
	public static String generateSalt() {
		return Utilities.generateCodes(16);
	}

	/**
	 * Generate Name: to generate name in Chinese ������������
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
