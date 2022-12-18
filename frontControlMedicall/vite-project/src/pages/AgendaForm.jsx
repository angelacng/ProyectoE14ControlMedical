import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { Container, Form, Row, Col, Button } from "react-bootstrap";
import { useNavigate, useParams } from "react-router-dom";
import { findAgendaById, findAllMedicos, guardarAgenda } from "../server/Server";


function AgendaForm() {
    const { id } = useParams();
    const navigate = useNavigate();
    function returnToAgenda() {
        navigate("/agenda");
    }

    //estructura de la agenda
    const [agenda, setAgenda] = useState(
        {
            fecha: "",
            id_medico: "",
            citas: []
        }
    );

    const [medicos, setMedicos] = useState([]);

    async function listarMedicos() {
        try {
            const response = await findAllMedicos();
            setMedicos(response);
        } catch (error) {
            console.log(error);
        }
    };

    useEffect(() => {
        if (id != undefined) {
            setDisabled(true)
            findAgendaById(id).then(
                res => { setAgenda(res) }
            )
        }
        listarMedicos();
    }, [id])


    function handleChange({ target }) {
        setAgenda({
            ...agenda,
            [target.name]: target.value
        })
        //   console.log(agenda);
    };

    async function handleSubmit(e) {
        e.preventDefault();
        const resp = await guardarAgenda(agenda);
        if (id != undefined){
            alert("Se actualizó la agenda: " + resp.id);
        }else{
            alert("Se creó la agenda: " + resp.id);
        }
        
        returnToAgenda();
    }

    const [disabled, setDisabled] = useState(false);

    return (
        <Container>
            <h1> {id != undefined ? "Detalle Agenda" : "Registrar Agenda"}</h1>
            <Form className="my-3" onSubmit={handleSubmit}>
                <Row>
                    <Col xs="auto" className="my-1">
                        <Form.Label>Fecha: </Form.Label>
                        <Form.Control

                            required
                            name="fecha"
                            placeholder="aaaa-mm-dd"
                            onChange={handleChange}

                            value={agenda.fecha}
                            disabled={disabled}
                        />
                    </Col>
                    <Col xs="auto" className="my-1">
                        <Form.Label>Medico</Form.Label>
                        <Form.Select required
                            name="id_medico"
                            onChange={handleChange}

                            disabled={disabled}
                        >
                            <option>{agenda.nombremedico} {agenda.apellidomedico}</option>
                            {
                                medicos.map((medico) => (
                                    <option key={medico.id} value={medico.id}>{medico.nombre} {medico.apellido}</option>
                                ))
                            }
                        </Form.Select>
                    </Col>
                    <Row>
                        <Col>
                            <Button variant="success" type="submit" disabled={disabled}> {id != undefined ? "Actualizar" : "Guardar"} </Button>
                        </Col>
                        <Col>
                            <Button hidden={!disabled} variant="warning" onClick={()=>setDisabled(!disabled)}> Editar</Button>
                        </Col>
                        <Col>
                            <Button onClick={returnToAgenda}> Regresar</Button>
                        </Col>

                    </Row>
                </Row>
            </Form>
        </Container>

    )
}
export { AgendaForm }
