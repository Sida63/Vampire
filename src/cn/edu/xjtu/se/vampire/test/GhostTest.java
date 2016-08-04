package cn.edu.xjtu.se.vampire.test;

public class GhostTest {
	private int id;
	private String name;

	public GhostTest() {
		// TODO Auto-generated constructor stub
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public static void main(String args[]){
		GhostTest gt=new GhostTest();
		gt.setName("我也不知道……");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
