import React, { useEffect, useState } from 'react'
import Header from './Header'
import axios from "axios";
import Properties from "./Properties";
import {Button} from "reactstrap";
import { NavLink } from 'react-bootstrap';

export default function Owner() {

  const [ownerProperties,setOwnerProperties]=useState([]);


  useEffect(()=>{
    const userId = sessionStorage.getItem("userID");
    console.log(userId);
    getAllOwnerProperties();
  },[]);

  const userId = sessionStorage.getItem("userID");
  const USER_API_BASE_URL = "http://localhost:8080/owner/properties/"+userId;

  const getAllOwnerProperties=()=>{

    axios.get(USER_API_BASE_URL).then(
      (response)=>{
          console.log(response.data);
          JSON.stringify(response);
          setOwnerProperties(response.data);
          console.log(ownerProperties);
      },
      (error)=>{
          console.log(error);
      }
  );

  }



  return (
    <>
    <Header></Header>
    <div>
   <Button
      style={{ margin: "5px" }}
      color="success"
      //onClick={}
    ><NavLink href='./AddProperty'>Add property</NavLink>
      
    </Button>
    </div>
    {ownerProperties.length > 0
            ? ownerProperties.map((item)=><div className='Allcards'><Properties  prop={item}/></div> 
            )
            :<div className='title'><h1>Nothing to show here..</h1></div>}
    
    </>
  )
}
