package library.mapper;

import org.apache.ibatis.annotations.Select;

import library.entities.Book;

public interface BookMapper {

	@Select("Select * From books Where id = #{id}")
	public Book getBook(Integer id);
}
