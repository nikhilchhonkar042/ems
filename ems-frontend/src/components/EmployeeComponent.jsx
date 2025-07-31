import React, { useState, useEffect } from 'react';
import { createEmployee, getEmployeeById, updateEmployee } from '../services/EmployeeService';
import { useNavigate, useParams } from 'react-router-dom';

const EmployeeComponent = () => {
  const navigate = useNavigate();
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const { id } = useParams();

  const [errors, setErrors] = useState({ // RENAMED to errors
    firstName: '',
    lastName: '',
    email: ''
  });

  useEffect(() => {
    if (id) {
      getEmployeeById(id)
        .then(response => {
          const employee = response.data;
          setFirstName(employee.firstName);
          setLastName(employee.lastName);
          setEmail(employee.email);
        })
        .catch(error => {
          console.error("Error fetching employee:", error);
        });
    }
  }, [id]);

  const saveOrUpdateEmployee = (e) => {
    e.preventDefault();
    if (!validateForm()) return;
    if (id) {
      const employee = { id, firstName, lastName, email };
      updateEmployee(id, employee)
        .then(() => navigate('/employees'))
        .catch(error => console.error("Error updating employee:", error));
    } else {
      const employee = { firstName, lastName, email };
      createEmployee(employee)
        .then(() => navigate('/employees'))
        .catch(error => console.error("Error creating employee:", error));
    }
  };

  function validateForm() {
    let formIsValid = true;
    const errorsCopy = { ...errors };

    if (!firstName) {
      errorsCopy.firstName = "First Name is required";
      formIsValid = false;
    } else {
      errorsCopy.firstName = "";
    }

    if (!lastName) {
      errorsCopy.lastName = "Last Name is required";
      formIsValid = false;
    } else {
      errorsCopy.lastName = "";
    }

    if (!email) {
      errorsCopy.email = "Email is required";
      formIsValid = false;
    } else {
      errorsCopy.email = "";
    }

    setErrors(errorsCopy);
    return formIsValid;
  }

  function pageTitle() {
    return id
      ? <h2 className='text-center'>Update Employee</h2>
      : <h2 className='text-center'>Add Employee</h2>;
  }

  return (
    <div className='container mt-5'>
      <div className='row'>
        <div className='card col-md-6 offset-md-3'>
          {pageTitle()}
          <form>
            <div className="mb-3">
              <label htmlFor="firstName" className="form-label">First Name</label>
              <input
                type="text"
                className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                id="firstName"
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
              />
              {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}
            </div>
            <div className="mb-3">
              <label htmlFor="lastName" className="form-label">Last Name</label>
              <input
                type="text"
                className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                id="lastName"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
              />
              {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}
            </div>
            <div className="mb-3">
              <label htmlFor="email" className="form-label">Email</label>
              <input
                type="email"
                className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                id="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
              {errors.email && <div className="invalid-feedback">{errors.email}</div>}
            </div>
            <button type="submit" className="btn btn-primary" onClick={saveOrUpdateEmployee}>Submit</button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default EmployeeComponent;
