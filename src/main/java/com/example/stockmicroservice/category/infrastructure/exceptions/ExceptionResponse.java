package com.example.stockmicroservice.category.infrastructure.exceptions;

import java.time.LocalDateTime;

public record ExceptionResponse (String message, LocalDateTime timeStamp){

}
