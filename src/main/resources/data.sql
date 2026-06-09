INSERT IGNORE INTO roles (id, nombre) VALUES
(1, 'ADMIN'),
(2, 'CLIENTE');

INSERT IGNORE INTO estados_mascota (id, nombre) VALUES
(1, 'DISPONIBLE'),
(2, 'EN_PROCESO'),
(3, 'ADOPTADA'),
(4, 'REGISTRADA');

INSERT IGNORE INTO prioridades_mascota (id, nombre) VALUES
(1, 'NORMAL'),
(2, 'URGENTE');

INSERT IGNORE INTO categorias_servicio (id, nombre) VALUES
(1, 'MEDICOS'),
(2, 'CUIDADO_Y_ESTETICA'),
(3, 'PREVENCION_Y_BIENESTAR');

INSERT IGNORE INTO servicios
(id, categoria_id, nombre, descripcion, duracion_estimada, precio, created_at, updated_at, activo)
VALUES
(1, 1, 'Consulta General', 'Evaluacion medica completa, diagnostico inicial y recomendaciones preventivas.', '1 hora', 50.00, NOW(), NOW(), true),
(2, 1, 'Cirugia', 'Procedimientos especializados con evaluacion previa y seguimiento posterior.', 'Segun procedimiento', 60.00, NOW(), NOW(), true),
(3, 1, 'Laboratorio', 'Analisis clinicos de apoyo para diagnosticos rapidos y mas seguros.', '20 min', 30.00, NOW(), NOW(), true),
(4, 2, 'Peluqueria', 'Bano, corte y cuidado estetico para que tu mascota se sienta comoda.', '1 hora', 50.00, NOW(), NOW(), true),
(5, 2, 'Guarderia', 'Cuidado seguro por horas, con supervision y ambiente tranquilo.', 'Por horas', 20.00, NOW(), NOW(), true),
(6, 2, 'Hospedaje', 'Estadia comoda y segura para mascotas que necesitan cuidado continuo.', 'Por dia', 30.00, NOW(), NOW(), true),
(7, 3, 'Vacunacion', 'Proteccion preventiva contra enfermedades comunes y seguimiento del calendario.', '20 min', 35.00, NOW(), NOW(), true),
(8, 3, 'Desparasitacion', 'Control de parasitos internos y externos como parte del cuidado preventivo.', '15 min', 15.00, NOW(), NOW(), true),
(9, 3, 'Emergencias', 'Atencion rapida para casos criticos que requieren evaluacion inmediata.', 'Atencion inmediata', 0.00, NOW(), NOW(), true);

INSERT IGNORE INTO estados_cita (id, nombre) VALUES
(1, 'PENDIENTE'),
(2, 'CONFIRMADA'),
(3, 'ATENDIDA'),
(4, 'CANCELADA');

INSERT IGNORE INTO metodos_pago (id, nombre) VALUES
(1, 'EFECTIVO'),
(2, 'YAPE'),
(3, 'PLIN'),
(4, 'TARJETA'),
(5, 'TRANSFERENCIA');

INSERT IGNORE INTO estados_pago (id, nombre) VALUES
(1, 'PENDIENTE'),
(2, 'PAGADO'),
(3, 'ANULADO');

INSERT IGNORE INTO estados_solicitud (id, nombre) VALUES
(1, 'PENDIENTE'),
(2, 'APROBADA'),
(3, 'RECHAZADA');
