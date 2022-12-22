import React from "react";
import { useEffect } from "react";
import { useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import Card from 'react-bootstrap/Card';
import { Link } from "react-router-dom";
import { listaAgendas } from "../server/Server";

function CardsAgenda() {

    const [agendas, setAgendas] = useState([]);

    async function listAgendas() {
        try {
            const response = await listaAgendas();
            setAgendas(response);
        } catch (error) {
            console.log(error);
        }
    };

    useEffect(() => {
        listAgendas();
    }, []);


    const fechaActual = new Date();

    return (
        <Row className="my-3">
            {
                agendas.filter(agenda => agenda.fecha > fechaActual.toISOString()).map((agenda) => (
                    <Col key={agenda.id}>
                        <Card style={{ width: '18rem' }}
                            className="mb-2"
                            border='info'
                        >
                            <Card.Body >
                                <Card.Title>{agenda.fecha}</Card.Title>
                                <Card.Subtitle className="mb-2 text-muted">Agenda disponible</Card.Subtitle>
                                <Card.Text>
                                    Dr(a). {agenda.nombremedico} {agenda.apellidomedico}
                                </Card.Text>
                                <Card.Text>
                                    {agenda.especialidad}
                                </Card.Text>
                                <Link to={`/agenda/citas/${agenda.id}`}>Agendar cita</Link>

                            </Card.Body>
                        </Card>
                    </Col>

                ))
            }

        </Row>



    )
}
export { CardsAgenda }