import React, { useEffect, useState } from 'react';
import { Link, useHistory, useParams } from 'react-router-dom/cjs/react-router-dom.min';
import EmployeeService from '../../services/EmployeeService';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { FiXSquare } from "react-icons/fi";
import { BiTrash } from "react-icons/bi";
import { CiEdit } from "react-icons/ci";

const ListEmployee = () => {

  const [employees, setEmployees] = useState([]);
  const [isOverlayVisible, setOverlayVisible] = useState(false);
  const [firstName, setfirstName] = useState('');
  const [lastName, setlastName] = useState('');
  const [emailId, setemailId] = useState('');
  const history = useHistory();
  const { id } = useParams();

  const notify = (message, type = 'success') => {
    const defaultOptions = {
      position: 'top-right',
      autoClose: 5000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
      theme: 'light',
    };

    const toastOptions = {
      success: {
        ...defaultOptions,
        type: 'success',
      },
      info: {
        ...defaultOptions,
        type: 'info',
      },
      warning: {
        ...defaultOptions,
        type: 'warning',
      },
      error: {
        ...defaultOptions,
        type: 'error',
      },
    };

    return toast(message, toastOptions[type]);
  };

  useEffect(() => {
    getAllEmployees();
  }, [])

  const getAllEmployees = () => {
    EmployeeService.getAllEmployees().then((res) => {
      setEmployees(res.data);
      console.log(res.data);
    }).catch(error => {
      console.log(error);
    })
  }

  const getEmployee = (id) => {
    EmployeeService.getEmployeeById(id).then((res) => {
      setfirstName(res.data.firstName);
      setlastName(res.data.lastName);
      setemailId(res.data.emailId);
    }).catch(error => {
      console.log(error);
    })
  }

  const deleteEmployee = (id) => {
    console.log(id);
    EmployeeService.deleteEmployee(id).then((res) => {
      notify('Deleted successfully');
      getAllEmployees();
    }).catch(error => {
      console.log(error);
    })
  }

  const saveOrUpdateEmployee = (e) => {
    e.preventDefault();

    const employee = { firstName, lastName, emailId };
    if (id) {
      EmployeeService.updateEmployee(id, employee).then((res) => {
        notify('Employee updated successfully!', 'info');
        history.push('/');
      }).catch(error => {
        console.log(error);
      });
    } else {
      EmployeeService.createEmployee(employee).then((res) => {
        notify('Employee added successfully!', 'success');
        console.log(res.data);
        getAllEmployees();
        handleCloseClick();
      }).catch(error => {
        console.log(error);
      });
    }
  };
  const btnEmployee = () => {
    if (id) {
      return "UPDATE";
    } else {
      return "ADD";
    }
  }

  const handleViewClick = () => {
    setOverlayVisible(true);
  };
  const handleCloseClick = () => {
    setOverlayVisible(false);
  };


  return (
    <div className='container'>
      <h2 className='text-center'>LIST EMPLOYEE</h2>
      <div>
        <a to="/add-employee"> <FiXSquare onClick={handleViewClick} /> </a>
      </div>
      <table className='table table-bordered table-stripe'>
        <thead>
          <tr>
            <td>ID</td>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Email</td>
            <td>Actions</td>
          </tr>
        </thead>
        <tbody>
          {
            employees.map((employee) =>
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.emailId}</td>
                <td>
                {/* <a to={`/update-employee/${employee.id}`} className='p-3'> <CiEdit onClick={handleViewClick} /> </a> */}
                  <Link to={`/update-employee/${employee.id}`} className='p-3'><CiEdit /></Link>
                  <BiTrash className='w-10 h-10' onClick={() => deleteEmployee(employee.id)} />
                </td>
              </tr>
            )
          }
        </tbody>
      </table>
      {isOverlayVisible && (
        <div className="overlay">
          <div className="overlay-content">
            <h5>Thêm sản phẩm</h5>
            <form action="">
              <div className='form-group mb-2'>
                <label className='form-label'>First Name</label>
                <input
                  type="text"
                  name="firstName"
                  placeholder='Enter first name'
                  className='form-control'
                  value={firstName}
                  onChange={(e) => setfirstName(e.target.value)}
                />
              </div>
              <div className='form-group mb-2'>
                <label className='form-label'>Last Name</label>
                <input
                  type="text"
                  name="lastName"
                  placeholder='Enter last name'
                  className='form-control'
                  value={lastName}
                  onChange={(e) => setlastName(e.target.value)}
                />
              </div>
              <div className='form-group mb-2'>
                <label className='form-label'>Email</label>
                <input
                  type="email"
                  name="emailId"
                  placeholder='Enter email'
                  className='form-control'
                  value={emailId}
                  onChange={(e) => setemailId(e.target.value)}
                />
              </div>

              <button className='btn btn-success' onClick={(e) => saveOrUpdateEmployee(e)}>{btnEmployee()}</button>
              {/* <Link to="" className="btn btn-danger mx-2">CANCEL</Link> */}
              <span onClick={handleCloseClick}>Hủy</span>
            </form>
          </div>
        </div>
      )}
      <ToastContainer />
    </div>
  )
}

export default ListEmployee
