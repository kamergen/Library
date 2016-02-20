package library.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import library.entities.BookInUse;
import library.entities.User;

public interface UserMapper {

	@Select("Select * From users Where id = #{id}")
	public User getUser(Integer id);

	@Select("Select * From users Where firstName = #{firstName} Or lastName = #{lastName} Or email = #{email}")
	public List<User> usersSearch(User user);

	@Select("Select * From users Where role != 'librarian' Order by firstName,lastName Desc")
	public List<User> getAllUser();

	@Insert("INSERT INTO users(firstName,lastName,password,avatar,email,role) Values (#{firstName},#{lastName},#{password},#{avatar},#{email},#{role})")
	public Boolean addUser(User user);

	@Delete("Delete From users Where id = #{id}")
	public Boolean deleteUser(Integer id);

	@Delete("Delete From booksInUse Where id_user = #{id_user} And id_book = #{id_book}")
	public Boolean passBook(BookInUse bookInUse);

	@Insert("INSERT INTO booksInUse (id_user,id_book,bookStatus,startDate,endDate) Value (#{id_user},#{id_book},#{bookStatus},#{startDate},#{endDate})")
	public Boolean takeBook(BookInUse bookInUse);

	@Update("Update booksInUse Set bookStatus = 1 Where id = #{id}")
	public Boolean updateBookInUse(Integer id);
	
	@Select("Select id From booksInUse Where id_book = #{id_book}")
	public Integer getReserveBook(Integer id_book);
	
	@Select("Select * From users Where email = #{email} And password = #{password}")
	public User login(User user);

	@Select("Select email,password From users Where email = #{email}")
	public User getLogin(String email);
	
	@Select("Select role From users Where email = #{email}")
	public User getRole(String email);
}
