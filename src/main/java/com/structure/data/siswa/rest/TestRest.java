package com.structure.data.siswa.rest;
/*package com.structure.data.siswa.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.structure.data.dto.DtoResponse;
import com.structure.data.dto.StudentDto;
import com.structure.data.model.Student;
import com.structure.data.siswa.dao.StudentDao;
import com.structure.data.util.ResponseUtil;

@Controller
@RequestMapping("/rest/siswa")
public class SiswaRest {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public @ResponseBody List<StudentDto> getAllStudent() {
		List<StudentDto> studentDtos = new ArrayList<>();
		List<Student> students = (List<Student>) studentDao.findAll();

		for (Student student : students) {
			StudentDto studentDto = new StudentDto();
			studentDto.setId(student.getId());
			studentDto.setName(student.getName());
			studentDto.setPlaceOfBirth(student.getPlaceOfBirth());
			studentDto.setDateOfBirth(student.getDateOfBirth());
			studentDto.setGender(student.getGender());
			studentDto.setLevel(student.getLevel());
			studentDto.setSchoolName(student.getSchoolName());
			studentDto.setClassroom(student.getClassroom());

			studentDtos.add(studentDto);
		}

		return studentDtos;
	}

	@RequestMapping(value = "/find-one", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody StudentDto getStudentById(@RequestBody Integer id) {

		Student student = studentDao.findOne(id);
		if (student != null) {
			StudentDto studentDto = new StudentDto();
			studentDto.setId(student.getId());
			studentDto.setName(student.getName());
			studentDto.setPlaceOfBirth(student.getPlaceOfBirth());
			studentDto.setDateOfBirth(student.getDateOfBirth());
			studentDto.setGender(student.getGender());
			studentDto.setLevel(student.getLevel());
			studentDto.setSchoolName(student.getSchoolName());
			studentDto.setClassroom(student.getClassroom());
			return studentDto;
		} else
			return null;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DtoResponse insertStudent(@RequestBody StudentDto data) {

		Student student = new Student();
		student.setName(data.getName());
		student.setPlaceOfBirth(data.getPlaceOfBirth());
		student.setDateOfBirth(data.getDateOfBirth());
		student.setGender(data.getGender());
		student.setLevel(data.getLevel());
		student.setSchoolName(data.getSchoolName());
		student.setClassroom(data.getClassroom());

		studentDao.save(student);

		return ResponseUtil.response(1, "Success");
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DtoResponse updateStudent(@RequestBody StudentDto data) {

		Student student = studentDao.findOne(data.getId());

		if (student != null) {
			student.setName(data.getName());
			student.setPlaceOfBirth(data.getPlaceOfBirth());
			student.setDateOfBirth(data.getDateOfBirth());
			student.setGender(data.getGender());
			student.setLevel(data.getLevel());
			student.setSchoolName(data.getSchoolName());
			student.setClassroom(data.getClassroom());

			studentDao.save(student);
		} else {
			return ResponseUtil.response(0, "Failed to update");
		}

		return ResponseUtil.response(1, "Success");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody DtoResponse deleteStudent(@RequestBody StudentDto data) {

		Student student = studentDao.findOne(data.getId());

		if (student != null) {
			studentDao.delete(student);
		} else {
			return ResponseUtil.response(0, "Failed to delete");
		}

		return ResponseUtil.response(1, "Success");
	}

}
*/