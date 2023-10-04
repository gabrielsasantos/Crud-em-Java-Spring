package br.com.start.conf;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.start.exception.ErroDeNegocioException;
import br.com.start.model.dto.ErroDto;

@RestControllerAdvice
public class ErroController {

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(ErroDeNegocioException.class)
	@ResponseBody
	public ResponseEntity<ErroDto> handle(ErroDeNegocioException e) {
		ErroDto erroDto = new ErroDto();
		erroDto.setErro(e.getErro());

		return ResponseEntity.status(e.getHttpStatus()).body(erroDto);
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public ErroDto handleBindException(BindException exception) {
		List<String> validacoes = new ArrayList<>();

		for (FieldError error : exception.getBindingResult().getFieldErrors()) {
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			validacoes.add(error.getField() + ": " + mensagem);
		}

		ErroDto erroDto = new ErroDto();
		erroDto.setErro("Erro de Validação");
		erroDto.setValidacoes(validacoes);

		return erroDto;
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ErroDto handleConstraintViolationException(ConstraintViolationException e) {
		List<String> validacoes = new ArrayList<>();

		for (ConstraintViolation<?> violation : e.getConstraintViolations()) {
			String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
			validacoes.add(path + ": " + violation.getMessage());
		}

		ErroDto erroDto = new ErroDto();
		erroDto.setErro("Erro de Validação");
		erroDto.setValidacoes(validacoes);

		return erroDto;
	}
		
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ValidationException.class)
	@ResponseBody
	public ErroDto handleNomeDuplicado(ValidationException e) {
		List<String> validacoes = new ArrayList<>();

		for (ConstraintViolation<?> violation : ((ConstraintViolationException) e).getConstraintViolations()) {
			String path = ((PathImpl) violation.getPropertyPath()).getLeafNode().getName();
			validacoes.add(path + ": " + violation.getMessage());
		}

		ErroDto erroDto = new ErroDto();
		erroDto.setErro("Erro de Validação");
		erroDto.setValidacoes(validacoes);

		return erroDto;
	}
}
