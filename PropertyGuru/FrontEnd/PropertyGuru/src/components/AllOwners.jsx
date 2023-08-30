import React, { useEffect, useState } from 'react'
import Table from 'react-bootstrap/Table';
import Header from './Header';
import axios from 'axios';
import Button from 'react-bootstrap/Button';

export default function AllOwners() {

    const [search,setSearch] = useState([]);

    let URL = "http://localhost:8080/owner";
    useEffect(()=>{
        getAllOwners();
    },[])

    const getAllOwners=()=>{
        axios.get(URL).then(
            (response)=>{
                console.log(response);
                JSON.stringify(response);
                setSearch(response.data);
            },
            (error)=>{
                console.log(error);
            }
        );
       };

    const deleteOwner=(ownerId)=>{
        console.log(ownerId);
        axios.delete(URL+"/"+ownerId).then(()=>{
            getAllOwners();
        }).catch();
    }

  return (

    <>
    <Header></Header>
    <h1>All Owners</h1>
    <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>Id</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Contact Number</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        {search.length>0?search.map((owner)=>(
            <tr key={owner.id}>
                <td>{owner.id}</td>
                <td>{owner.firstName}</td>
                <td>{owner.lastName}</td>
                <td>{owner.email}</td>
                <td>{owner.contactNumber}</td>
                <td><Button variant="danger" onClick={()=>{deleteOwner(owner.id)}}>DELETE</Button></td>
            </tr>
        )):"No owner"}
      </tbody>
    </Table>
    </>
  );
}
    
