package library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import library.entities.BookInUse;
import library.entities.User;

public interface UserMapper {

	@Select("Select * From users Where id = #{id}")
	public User getUser(Integer id);

	@Select("Select * From users Where firstName = #{firstName} OR lastName = #{lastName} OR email = #{email}")
	public List<User> usersSearch(User user);

	@Select("Select * From users Where role != 'librarian' Order by firstName,lastName Desc")
	public List<User> getAllUser();

	@Insert("INSERT INTO users(firstName,lastName,password,avatar,email,role) values (#{firstName},#{lastName},#{password},#{avatar},#{email},#{role})")
	public Boolean addUser(User user);

	@Delete("Delete From users Where id = #{id}")
	public Boolean deleteUser(Integer id);

	@Delete("Delete From booksInUse Where id_user = #{id_user} And id_book = #{id_book}")
	public Boolean passBook(BookInUse bookInUse);

	@Insert("INSERT INTO booksInUse (id_user,id_book,bookStatus,startDate,endDate) value (#{id_user},#{id_book},#{bookStatus},#{startDate},#{endDate})")
	public Boolean takeBook(BookInUse bookInUse);

	@Select("Select * From users Where email = #{email} AND password = #{password}")
	public User login(User user);

}
