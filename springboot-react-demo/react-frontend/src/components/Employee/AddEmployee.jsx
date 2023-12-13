import React, { useEffect, useState } from 'react';
import EmployeeService from '../../services/EmployeeService';
import { Link, useHistory, useParams } from 'react-router-dom/cjs/react-router-dom.min';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const AddEmployee = () => {

    const [firstName, setfirstName] = useState('');
    const [lastName, setlastName] = useState('');
    const [emailId, setemailId] = useState('');
    const history = useHistory();
    const {id} = useParams();
    
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

    const saveOrUpdateEmployee = (e) => {
        e.preventDefault();

        const employee = {firstName, lastName, emailId};
        if(id) {
            EmployeeService.updateEmployee(id, employee).then((res) => {
                notify('Employee updated successfully!', 'info');
                history.push('/');
            }).catch(error => {
                console.log(error);
            });
        }else {
            EmployeeService.createEmployee(employee).then((res) =>  {
                notify('Employee added successfully!', 'success');
                console.log(res.data);
                history.push('/');
            }).catch(error => {
                console.log(error);
            });
        }
    };

    useEffect(() => {
      EmployeeService.getEmployeeById(id).then((res) => {
        setfirstName(res.data.firstName);
        setlastName(res.data.lastName);
        setemailId(res.data.emailId);
      }).catch(error => {
        console.log(error);
      })
    }, [id])
    
    const title = () => {
        if(id) {
            return <h2 className='text-center'>Update Employee</h2>
        }else {
            return <h2 className='text-center'>Add Employee</h2>
        }
    }
    const btnEmployee = () => {
        if(id) {
            return "UPDATE";
        }else {
            return "ADD";
        }
    }

    return (
        <div className='container'>
            <div className='row'>
                <div className='card col-md-6 offset-md-3'>
                    { title() }
                    <div className='card-body'>
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
                            <Link to="" className="btn btn-danger mx-2">CANCEL</Link>
                        </form>
                    </div>
                </div>
            </div>
            <ToastContainer />
        </div>
    );
};

export default AddEmployee