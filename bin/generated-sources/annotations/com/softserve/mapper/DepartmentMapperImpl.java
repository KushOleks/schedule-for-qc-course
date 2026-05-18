package com.softserve.mapper;

import com.softserve.dto.DepartmentDTO;
import com.softserve.entity.Department;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-18T11:16:34+0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.46.0.v20260407-0427, environment: Java 21.0.10 (Eclipse Adoptium)"
)
@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDTO departmentToDepartmentDTO(Department department) {
        if ( department == null ) {
            return null;
        }

        DepartmentDTO.DepartmentDTOBuilder departmentDTO = DepartmentDTO.builder();

        departmentDTO.disable( department.isDisable() );
        departmentDTO.id( department.getId() );
        departmentDTO.name( department.getName() );

        return departmentDTO.build();
    }

    @Override
    public Department departmentDTOToDepartment(DepartmentDTO departmentDTO) {
        if ( departmentDTO == null ) {
            return null;
        }

        Department department = new Department();

        department.setDisable( departmentDTO.isDisable() );
        department.setId( departmentDTO.getId() );
        department.setName( departmentDTO.getName() );

        return department;
    }

    @Override
    public List<DepartmentDTO> departmentsToDepartmentDTOs(List<Department> departments) {
        if ( departments == null ) {
            return null;
        }

        List<DepartmentDTO> list = new ArrayList<DepartmentDTO>( departments.size() );
        for ( Department department : departments ) {
            list.add( departmentToDepartmentDTO( department ) );
        }

        return list;
    }
}
