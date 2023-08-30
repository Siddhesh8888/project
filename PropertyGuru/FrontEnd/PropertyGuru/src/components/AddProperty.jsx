import React, { useState } from 'react'
import axios from "axios";
import {navigate,useNavigate} from "react-router-dom";
import Header from "./Header";
import Footer from "./footer/Footer";
import { toast } from "react-toastify";

export default function AddProperty() {
    const [property, setProperty] = useState({
        name: "",
        description: "",
        propType: "",
        propertyFor: "",
        area: "",
        bedrooms: "",
        line1:"",
        line2:"",
        pincode:"",
        city: "",
        state:"",
        price:"",
        amenities:"",
        registartionId:"",
        imageURL:""
      });

    //   const[imageURL, setImageURL]=useState('');
    
      const [address, setAddress]=useState({
        line1:"",
        line2:"",
        pincode:"",
        city: "",
        state:""
      })
    
    const handleChange = (e) => {
      const value = e.target.value;
          setProperty({
          ...property,
          [e.target.name]: value,
          
      });
      setAddress({...address, [e.target.name]: value}) //line1:, line2:data.line2, city:data.city, state:data.state, pincode:data.pincode})
    
    };
    
    let navigate=useNavigate();
    const ownerId = sessionStorage.getItem("userID");
    console.log(ownerId);

    const USER_API_BASE_URL = "http://localhost:8080/owner/property/"+ownerId;
    const handleSubmit = (e) =>
    {
      e.preventDefault();
        
        const propertyData = {
            name: property.name,
            description: property.description,
            propType: property.propType,
            propertyFor: property.propertyFor,
            area: property.area,
            bedrooms: property.bedrooms,
            address:address,
            status:"APPROVED",
            price:property.price,
            amenities:property.amenities,
            registartionId:property.registartionId,
            imageURL:property.imageURL
        };
        console.log(propertyData);
      axios.post(USER_API_BASE_URL, propertyData).then(
        (response)=>{
            console.log(response);
            JSON.stringify(response);
            toast.success("Your property added successfully");
            navigate("/owner");
            
        },
        
    ).catch((error)=>
    console.log(error.response)
    )
    }
    
    
      return (
        <div>
    <div>
    <Header></Header>
    
        <div className="SignUp" >
          
          <div className="Auth-form-container"  >
          <div className=" col-md-4 col-lg-6 bg-image" style={{margin:"auto"}}>
          <div className="col-md-8 col-lg-6"></div>
          <div className="login d-flex align-items-center py-5" >
          <form className="Auth-form" onSubmit={handleSubmit} style={{marginTop:"100px", margin:"auto"}}>
          <h3 className="Auth-form-title">Register Property</h3>
          <div className="form-group mt-2"></div>
          <label>Name</label>
              <input
                type="text"
                name="name"
                value={property.name}
                onChange={handleChange}
                className="form-control mt-2"
                placeholder="Enter Name" style={{width:"400px" ,margin:"auto"}}
              />
              <div className="form-group mt-2" >
              <label style={{textAlign : 'left'}}>Description</label>
                <input
                   type="text"
                    name="description"
                    value={property.description}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter Description"style={{width:"400px" ,margin:"auto"}}
                  />
                </div>


                <div className="form-group mt-2" >
              <label style={{textAlign : 'left'}}>Property Type</label>
                <input
                   type="text"
                    name="propType"
                    value={property.propType}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter Propety Type"style={{width:"400px" ,margin:"auto"}}
                  />
                </div>

                {/* <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Property Type</label>
                <select style={{width:"400px" ,margin:"auto"}} className="form-select" name='propertyType' onChange={handleChange}>
                    <option selected>--------------Select Propety Type-------------</option>
                    <option value={property.propType}>BUNGLOW</option>
                    <option value="FLAT">FLAT</option>
                    <option value="PLOT">PLOT</option>
                    <option value="SHOP">SHOP</option>
                    <option value="OFFICE">OFFICE</option>
                    <option value="WAREHOUSE">WAREHOUSE</option>
                    <option value="HOSTEL">HOSTEL</option>
                    <option value="PG">PG</option>
                </select>
                </div> */}


                {/* <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Property For</label>
                <select style={{width:"400px" ,margin:"auto"}} className="form-select" >
                    <option selected>--------------Select Propety For-------------</option>
                    <option>RENT</option>
                    <option>SELL</option>
                </select>
                </div> */}

                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Property For</label>
                <input
                   type="text"
                    name="propertyFor"
                    value={property.propertyFor}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter Property For"style={{width:"400px" ,margin:"auto"}}
                  />
                </div>


                < div className="form-group mt-3" >
                <label style={{textAlign : 'left'}}>Area</label>
                <input
                   type="number"
                    name="area"
                    value={property.area}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter Area" style={{width:"400px" ,margin:"auto"}}
                  />
                
                
                <label style={{textAlign : 'left'}}>No of Bedrooms</label>
                <input
                   type="number"
                    name="bedrooms"
                    value={property.bedrooms}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter No. of Rooms" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>
                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Price</label>
                <input
                   type="number"
                    name="price"
                    value={property.price}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter Price" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>
                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Address Line 1</label>
                <input
                   type="text"
                    name="line1"
                    value={address.line1}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter address line1" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>
                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Address Line 2</label>
                <input
                   type="text"
                    name="line2"
                    value={address.line2}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter address line2" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>
                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>City</label>
                <input
                   type="text"
                    name="city"
                    value={address.city}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter city" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>
                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>State</label>
                <input
                   type="text"
                    name="state"
                    value={address.state}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter state" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>
                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Pincode</label>
                <input
                   type="text"
                    name="pincode"
                    value={address.pincode}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter state" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>

                
                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Amenities</label>
                <input
                   type="text"
                    name="amenities"
                    value={property.amenities}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter Amenities" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>

                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Registration Id</label>
                <input
                   type="number"
                    name="registartionId"
                    value={property.registartionId}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter Registration Id" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>

                {/* <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Image</label>
                <input
                   type="file"
                    name="imageURL"
                    files = {imageURL}
                    onChange={(e)=>setImageURL(e.target.files[0])}
                    className="form-control mt-1"
                    placeholder="Upload Image" style={{width:"400px" ,margin:"auto"}}
                  />
                </div> */}

                <div className="form-group mt-2" >
                <label style={{textAlign : 'left'}}>Image</label>
                <input
                   type="text"
                    name="imageURL"
                    value={property.imageURL}
                    onChange={handleChange}
                    className="form-control mt-1"
                    placeholder="Enter Image URL" style={{width:"400px" ,margin:"auto"}}
                  />
                </div>
                
                <div/>
                
            <br></br>
            <button type="submit" className="btn btn-dark">ADD PROPERTY</button>
            
            
          </form>
          </div>
          </div>
          </div>
        </div>
        
        
        </div>
        </div>
      );
}
