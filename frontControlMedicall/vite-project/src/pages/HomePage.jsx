import React from "react";
import { Container } from "react-bootstrap";
import Carousel from 'react-bootstrap/Carousel';

function HomePage() {
    return (
        <main >
            <Container >

                <Carousel>
                    <Carousel.Item>
                        <img
                       className="d-block mh-50"
                            src="https://res.cloudinary.com/dffbjjc7o/image/upload/v1671677729/WhatsApp_Image_2022-12-21_at_9.55.10_PM_ppomo7.jpg"
                            alt="First slide"
                        />
                        <Carousel.Caption>
                            <h1>Control Medicall</h1>
                           
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                         className="d-block mh-50"
                            src="https://res.cloudinary.com/dffbjjc7o/image/upload/v1671678861/WhatsApp_Image_2022-12-21_at_10.13.38_PM_fdxzmg.jpg"
                            alt="Second slide"
                        />

                        <Carousel.Caption>
                            <h1>Control Medicall</h1>
                           
                        </Carousel.Caption>
                    </Carousel.Item>
                    <Carousel.Item>
                        <img
                       //     className="d-block w-10"
                            src="https://res.cloudinary.com/dffbjjc7o/image/upload/v1671679860/WhatsApp_Image_2022-12-21_at_10.30.42_PM_yrhbeu.jpg"
                            alt="Third slide"
                        />

                       
                    </Carousel.Item>
                </Carousel>
            </Container>
        </main>

    );
}
export { HomePage }