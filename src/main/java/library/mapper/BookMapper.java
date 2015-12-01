package library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import library.entities.NewBook;

public interface BookMapper {

	@Select("Select * From books Where id = #{id}")
	public NewBook getBook(Integer id);

	@Select("Select * From books")
	public List<NewBook> getAllBook();
	
	@Insert("INSERT INTO books(id,title,publishingHouse,years,pageNumber) values (#{id},#{title},#{publishingHouse},#{years},#{pageNumber})")
	public NewBook addBook(NewBook books);

}
