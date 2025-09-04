FROM composer:2.8.11 AS vendor

WORKDIR /app
COPY composer.json composer.lock /app/

RUN composer install --no-dev --optimize-autoloader

FROM php:8.4.11-apache AS dist

COPY --from=vendor /app/vendor /var/www/html/vendor/
COPY index.php /var/www/html/
