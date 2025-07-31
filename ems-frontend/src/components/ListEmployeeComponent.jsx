import React, { useEffect, useState } from 'react';
import { listEmployees } from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch(error => {
        console.error("There was an error fetching the employee data!", error);
      });
  }, []);

  return (
    <div className='container mt-5'>
      <h2 className='text-center'>List of Employee</h2>
      <button className='btn btn-primary mb-2' onClick={() => navigate('/add-employee')}>Add Employee</button>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Employee ID</th>
            <th>Employee First Name</th>
            <th>Employee Last Name</th>
            <th>Employee Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(employee =>
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
              <td>{employee.email}</td>
              <td>
                <button className='btn btn-info' onClick={() => navigate(`/view-employee/${employee.id}`)}>View</button>
                <button className='btn btn-warning mx-2' onClick={() => navigate(`/update-employee/${employee.id}`)}>Update</button>
                <button className='btn btn-danger' onClick={() => navigate(`/delete-employee/${employee.id}`)}>Delete</button>
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
