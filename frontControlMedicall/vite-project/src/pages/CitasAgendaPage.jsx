import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { Button, Col, Container, FormCheck, Row } from "react-bootstrap";
import { Form, useNavigate, useParams } from "react-router-dom";
import { findAgendaById, guardarAgenda } from "../server/Server";

function CitasAgendaPage() {
    const { id } = useParams();
    const [agenda, setAgenda] = useState({});
    const [horaRadio,sethoraRadio]=useState("");
    const navigate = useNavigate();
    const franjaHoraria=["8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30"];

    function returnToHome() {
        navigate("/");
    }

    useEffect(() => {
        findAgendaById(id).then(data => {
            setAgenda(data);
        });
    }, []);

    const handleSelect =(e)=>{
        sethoraRadio(e.target.value);
    }

    async function handleSubmit(){
        if(horaRadio!==""){
            agenda.citas.push({hora:horaRadio,id_paciente:""});
            guardarAgenda(agenda);
            alert("Se agendó la cita");          
            returnToHome();
        }else{
            alert("Seleccione un horario")
        }

    }

   

    return (
        <Container className="my-3">
            <Row>
                <Col>
                    <p> Fecha Cita:</p>
                    <h4>{agenda.fecha}</h4>
                </Col>
                <Col>
                    <p>Nombre del médico</p>
                    <h4>{agenda.nombremedico} {agenda.apellidomedico}</h4>
                </Col>
                <Col>
                    <p>Especialidad:</p>
                    <h4>{agenda.especialidad}</h4>
                </Col>
            </Row>
            <Row className="my-3">
                <Col xs lg="2">
                    Horarios Disponibles:
                </Col>
                <Col md="auto">
                    {
                        franjaHoraria.map((hora)=>(
                            <FormCheck className="my-3"
                            key={hora}
                            label={hora+" AM"}
                            type="radio"
                            name="hora"
                            value={hora}
                            onChange={handleSelect}
                            />     
                        )
                            )
                    }
                </Col>
              {/*}  <Col xs lg="2">
                <FormLabel>N° de Id del paciente</FormLabel>
                <FormControl/>
                </Col>*/}
            </Row>
            <Row>
                <Col>
                <Button variant="success" onClick={()=>{handleSubmit()}}>Registrar Cita</Button>
                </Col>
            </Row>
        </Container>

    )
}
export { CitasAgendaPage }