# CI/CD Pipeline with Spring Boot & Kubernetes

A complete CI/CD implementation deploying a Spring Boot microservice to AWS EKS via GitHub Actions.

## Features
- Spring Boot REST API for product management
- Automated build and containerization
- Kubernetes deployment on AWS EKS
- GitHub Actions CI/CD pipeline

## Prerequisites
- Java 26
- Docker
- kubectl
- AWS account with EKS cluster
- GitHub repository

## Quick Start
1. Create your own Kubernetes cluster using AWS EKS service. use eksctl tool to create cluster on AWS EKS through command prompt.
   Use chocolatey to install the eksctl tool.
   
   Install Chocolatey - https://chocolatey.org/install (for windows)
   
   To install eksctl on Windows using Chocolatey, execute your command in an elevated terminal (Run as Administrator)
   
   choco install eksctl -y
   
   Verify the installation by running the following command - eksctl version
   
   Create cluster using eksctl tool --> eksctl create cluster --name my-first-cluster --region us-east-1 --nodes 2
   
   Here "my-first-cluster" is the name of the cluster.

   Documentation Links:
   
   https://docs.aws.amazon.com/eks/latest/eksctl/what-is-eksctl.html
   
   https://docs.aws.amazon.com/eks/latest/userguide/getting-started-eksctl.html

## Architecture
[diagram or description]

## API Endpoints
[documentation]

## Deployment
[how the pipeline works]

## Troubleshooting
[common issues]
