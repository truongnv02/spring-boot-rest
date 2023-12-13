import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ListEmployee from './components/Employee/ListEmployee';
import Footer from './components/Footer/Footer';
import Header from './components/Header/Header';
import AddEmployee from './components/Employee/AddEmployee';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {
  return (
    <div>
      <Router>
        <Header />
        <div className='container'>
          <Switch>
            <Route path="/add-employee" component={AddEmployee}></Route>
            <Route path="/update-employee/:id" component={AddEmployee}></Route>
            <Route path="/" component={ListEmployee}></Route>
            <Route path="/employees" component={ListEmployee}></Route>
          </Switch>
        </div>
        <Footer />
        <ToastContainer />
      </Router>
    </div>
  );
}

export default App;
