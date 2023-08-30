
import axios from "axios";
import { useState } from "react";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import { toast } from "react-toastify";
import Admin from "./Admin";
import {
  Dropdown,
  NavItem,
  DropdownMenu,
  DropdownToggle,
  DropdownItem,
  UncontrolledDropdown,
  Form,
  Button,
} from "reactstrap";

const Header = () => {
  const [Interval, setInterval] = useState([]);
  let userRole = JSON.parse(sessionStorage.getItem("user"));
  // console.log("ajdjk"+userRole.userRole);
  // let role=JSON.stringify(userRole.userRole);
  const clearSession = () => {
    setInterval(() => {
      toast.success("You Have been Succesfully Signed Out");
    }, 3000);

    sessionStorage.clear();
  };

  let user = JSON.parse(sessionStorage.getItem("user"));
  let userName;
  if (user) {
    userName = user.firstName;
  }
  return (
    <Navbar collapseOnSelect expand="lg" bg="black" variant="dark">
      <Navbar.Brand href="/" style={{ marginLeft: "40px" }}>
       <img src={"../images/logo4.jpg"} height={"80px"} width={"180px"} alt=""  />
      </Navbar.Brand>

      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
        <Nav>
          {sessionStorage.getItem("token") && userRole.userRole.includes("ROLE_ADMIN") && (
            <NavItem
              className="userNav"
              style={{ alignContent: "right", marginLeft: "1300px" }}
            >
              <UncontrolledDropdown nav inNavbar>
                <DropdownToggle nav caret>
                  Welcome {userRole.firstName}
                </DropdownToggle>
                <DropdownMenu right>
                  <DropdownItem href="#">
                    Verify Property
                  </DropdownItem>
                  
                  <DropdownItem divider />
                  <DropdownItem>Get list of Owners</DropdownItem>
                  <DropdownItem href="./" onClick={clearSession}>
                    Sign Out
                  </DropdownItem>
                </DropdownMenu>
              </UncontrolledDropdown>
            </NavItem>
          )}
        </Nav>

        {/* <Nav>
          {sessionStorage.getItem("token") && userRole.userRole === "ROLE_ADMIN" && (
            <NavItem>
              <Nav.Link href="./Admin">Dashboard</Nav.Link>
            </NavItem>
          )}
        </Nav> */}

        {!sessionStorage.getItem("token") && (
          <Nav className="me-auto" >
            <NavItem style={{ marginLeft: "50px"}}>
              <Nav.Link href="./SignUpUser"><b>Register As User</b></Nav.Link>
            </NavItem>
            <NavItem style={{ marginLeft: "50px"}}>
              <Nav.Link href="./SignUpSeller"><b>Register As Owner</b></Nav.Link>
            </NavItem>
            <NavItem style={{ marginLeft: "50px" }}>
              <Nav.Link href="./Login"><b>Login</b></Nav.Link>
            </NavItem>
          </Nav>
        )}

        <Nav>
          {sessionStorage.getItem("token") &&
            (userRole.userRole === "ROLE_BUYER") && (
              <NavItem style={{ marginLeft: "100px" }}>
                <Nav.Link href="/Wishlist"><b>Wishlist</b></Nav.Link>
              </NavItem>
            )}
        </Nav>

        <Nav>
          {sessionStorage.getItem("token") &&
            (userRole.userRole === "ROLE_OWNER") && (
              <NavItem style={{ marginLeft: "100px" }}>
                <Nav.Link href="/Owner"><b>Properties</b></Nav.Link>
              </NavItem>
            )}
        </Nav>

        <Nav>
          {sessionStorage.getItem("token") &&
            !(userRole.userRole === "ROLE_ADMIN") && (
              <NavItem style={{ marginLeft: "50px", marginRight: "10px" }}>
                <Nav.Link href="/AboutUs"><b>AboutUs</b></Nav.Link>
              </NavItem>
            )}
        </Nav>
        <Nav>
          {sessionStorage.getItem("token") &&
            !(userRole.userRole =="ROLE_ADMIN") && (
              <NavItem style={{ marginLeft: "50px", marginRight: "10px" }}>
                <Nav.Link href="/Appointments"><b>Appointments</b></Nav.Link>
              </NavItem>
            )}
        </Nav>
        <Nav>
          {sessionStorage.getItem("token") &&
            (userRole.userRole =="ROLE_ADMIN") && (
              <NavItem style={{ marginLeft: "50px", marginRight: "10px" }}>
                <Nav.Link href="/AllOwners"><b>Owners</b></Nav.Link>
              </NavItem>
            )}
        </Nav>
        {/* <Nav>
          <NavItem>
          {sessionStorage.getItem("token")&&
            <Nav.Link href="./" onClick={clearSession}>
              Sign Out
            </Nav.Link>
            }
          </NavItem>
          </Nav> */}
        {sessionStorage.getItem("token") && (
          <Nav>
            <NavItem
              className="userNav"
              style={{ alignContent: "right", marginLeft: "500px" }}
            >
              <UncontrolledDropdown nav inNavbar>
                <DropdownToggle nav caret>
                 <b>Welcome  &nbsp;&nbsp;{userName}</b>  &nbsp;&nbsp;&nbsp;<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
</svg>
                </DropdownToggle>
                <DropdownMenu right>
                  <DropdownItem href="/updatePassword">
                    Update Password
                  </DropdownItem>
                  <DropdownItem href="/viewOrders">Profile</DropdownItem>
                  <DropdownItem divider />
                  <DropdownItem>update profile</DropdownItem>
                  <DropdownItem href="./" onClick={clearSession}>
                    Sign Out
                  </DropdownItem>
                </DropdownMenu>
              </UncontrolledDropdown>
            </NavItem>
          </Nav>
        )}
      </Navbar.Collapse>
    </Navbar>
  );
};

export default Header;
