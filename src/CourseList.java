import java.util.*;

public class CourseList 
{
	private Collection<CourseDTO> courseList;

	public CourseList()
	{
		this(new LinkedList<CourseDTO>());
	}
	public CourseList(Collection<CourseDTO> courseList)
	{
		this.courseList = courseList;
	}
	public Collection<CourseDTO> getCourseList()
	{
		return courseList;
	}
	public void setCourseList(Collection<CourseDTO> courseList)
	{
		this.courseList = courseList;
	}
	public CourseDTO addCourseList(CourseDTO courseDTO)
	{
		if(courseDTO != null)
		{
			courseList.add(courseDTO);
			return courseDTO;
		}
		else
			return null;
	}
}
