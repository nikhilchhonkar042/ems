import React, { useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { deleteEmployee } from '../services/EmployeeService';

const DeleteEmployeeComponent = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    if (id) {
      deleteEmployee(id)
        .then(() => navigate('/employees'))
        .catch(() => navigate('/employees'));
    } else {
      navigate('/employees');
    }
  }, [id, navigate]);

  return <div>Deleting employee...</div>;
};

export default DeleteEmployeeComponent;
