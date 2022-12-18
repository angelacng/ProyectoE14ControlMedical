import React from "react";
import { Col, Container, Row } from "react-bootstrap";

function NotFound() {

    return (
        <Container>
            <Row className="justify-content-md-center">
                <Col md="auto">
                <img src="https://media.tenor.com/FcVg5W9zZJQAAAAC/error.gif" alt="NotFound" />
            </Col>
            </Row>
        </Container>

    )
} export { NotFound }