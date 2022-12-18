import React, { useState } from "react";
import { useEffect } from "react";
import { Container, Table, Row, Col, Button, FormControl, FormLabel } from "react-bootstrap";
import { Link } from "react-router-dom";
import { eliminarAgendaPorId, listaAgendas } from "../server/Server";


function TablaAgendas() {

    const [agendas, setAgendas] = useState([]);

    async function cargarAgendas() {
        /*  const options = {method: 'GET'};
         fetch('http://localhost:8080/agendas/', options)
           .then(response => response.json())
           .then(response => setAgendas(response))
           .catch(err => console.error(err));*/
        try {
            const res = await listaAgendas();
            setAgendas(res);
        } catch (error) {
            console.log(error);
        }

    };
    useEffect(() => {
        cargarAgendas();
    }, [])

    async function deleteAgendaById(id){
        let result=window.confirm("Está seguro de eliminar la agenda?");
        if(result){
            const response=await eliminarAgendaPorId(id);
            alert(response);
            setAgendas(agendas.filter(agenda=>agenda.id!=id));
        }
/*        try{

        }catch(error){
            console.log(error);
        }*/
    }

    let contador = 0;

    return (
        <Container>

            <Row className="my-3">
                <Col><h2>Lista de Agendas</h2></Col>

            
                <Col xs lg="2">
                    <Link to="/agenda/form">
                        <Button variant="success">Registrar</Button>
                    </Link>
                </Col>
            </Row>

            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Id Agenda</th>
                        <th>Fecha</th>
                        <th> Id Médico</th>
                        <th> Nombre Médico</th>
                        <th> Especialidad</th>
                        <th> Ver detalle</th>
                        <th> Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        agendas.map((agenda) => (
                            <tr key={agenda.id}>
                                <td>{++contador}</td>
                                <td>{agenda.id}</td>
                                <td>{agenda.fecha}</td>
                                <td>{agenda.id_medico}</td>
                                <td>{agenda.nombremedico} {agenda.apellidomedico}</td>
                                <td>{agenda.especialidad}</td>
                                <td><Link to={`/agenda/${agenda.id}`}>Ver Detalle</Link></td>
                                <td><Button variant="danger" onClick={()=>deleteAgendaById(agenda.id)}>Eliminar</Button></td>
                            </tr>
                        ))
                    }
                </tbody>
            </Table>
        </Container>
    )
}
export { TablaAgendas }