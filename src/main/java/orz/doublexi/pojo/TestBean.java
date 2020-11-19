package orz.doublexi.pojo;

public class TestBean {
	private String name;

	
	public TestBean() {
		System.out.println(this.getClass());
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
