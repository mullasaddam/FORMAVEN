package pojo;

public class PostAPIPojo {
	

	private String Name;
	private String Job;
	public PostAPIPojo( String name, String job) {
		
		this.Name = name;
		this.Job = job;
	}
	 @Override
	 public String toString() {
			return "PostAPIPojo [Name=" + this.Name + ", Job=" + this.Job + "]";
		}

	
	public String getName() {
		return Name;
	}

  public void setName(String name) {
		Name = name;
	}

   public String getJob() {
		return Job;
	}

  public void setJob(String job) {
		Job = job;
	}

  
	
	
	
}
