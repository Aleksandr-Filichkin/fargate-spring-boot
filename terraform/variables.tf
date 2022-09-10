variable "aws_access_key" {
  default = ""
}
variable "aws_secret_key" {
  default = ""
}

variable "region" {
  type = string
  default = "us-east-1"
}
variable "name" {
  description = "the name of your stack, e.g. \"demo\""
}

variable "environment" {
  description = "the name of your environment, e.g. \"prod\""
}

variable "cidr" {
  description = "The CIDR block for the VPC."
}

variable "public_subnets" {
  description = "List of public subnets"
}

variable "availability_zones" {
  description = "List of availability zones"
}

variable "container_port" {
  description = "The port where the Docker is exposed"
  default     = 8080
}

variable "container_cpu" {
  default = "256"
}
variable "container_memory" {
  default = "512"
}
variable "container_image" {
  default = "test"
}
variable "container_environment" {
  default = "test"
}
variable "service_desired_count" {
  default = "1"
}

variable "health_check_path" {
  default = "/health"
}

# Redirect traffic to target group
variable "alb_tls_cert_arn" {
  default = "arn:aws:acm:eu-west-1:140729813405:certificate/516bff03-d1de-4252-8a24-fd47190a9aa8"
}