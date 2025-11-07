const path = require('path');
const express = require('express');
const bodyParser = require('body-parser');
const axios = require('axios');
const { render } = require('ejs');
const SPRING_BOOT = process.env.API_URL || 'http://localhost:8080/api'
const app = express();
app.set('view engine', 'ejs');
app.set('views', path.join(__dirname, 'views'));
app.use(bodyParser.urlencoded({ extended: true }));

app.get('/', async (req, res) => {
  try{
    const response = await axios.get(`${SPRING_BOOT}/clientes`);
    res.render('index', { clientes: response.data });
  }catch(error){
    console.error('Erro ao buscar clientes: ', error.message);
    res.render('error', {message: 'Erro ao carregar clientes'});
  }
  
});

app.get('/novo', async (req, res) => {
  res.render('form', {cliente: {}, action: '/novo'});
})

app.post('/novo', async (req, res) => {
  console.log('Dados recebidos do formulario: ', req.body);
  try{
    const response = await axios.post(`${SPRING_BOOT}/clientes/novo`, req.body);
    res.redirect('/');
  }catch(error){
    console.error('Erro ao criar cliente: ', error.message);
    res.render('error', {message: 'Erro ao criar cliente'});
  }
})

app.get('/detalhes/:id', async (req, res) => {
  try{
    const response = await axios.get(`${SPRING_BOOT}/clientes/detalhes/${req.params.id}`);
    console.log('Acessando detalhes do usuario', response.data);
    res.render('detalhes', {cliente: response.data});
  }catch(error){
    console.error('Erro ao buscar cliente: ', error.message);
    res.render('error', {message: 'Erro ao buscar cliente'});
  }
})

app.get('/editar/:id', async (req, res) => {
  try{
    const response = await axios.get(`${SPRING_BOOT}/clientes/detalhes/${req.params.id}`);
    res.render('form', {cliente: response.data, action: `/editar/${req.params.id}`});
  }catch(error){
    res.render('error', {message: 'Cliente não encontrado'});
  }
})


app.post('/editar/:id', async (req, res) => {
  try{
    await axios.post(`${SPRING_BOOT}/clientes/editar${req.params.id}`, req.body);
    res.redirect('/');
  }catch(error){
    console.error('Erro ao atualizar cliente: ', error.message);
    res.render('error', {message: 'Erro ao atualizar cliente'});
  }
})

app.get('/excluir/:id', async (req, res) => {
  try{
    const response = await axios.delete(`${SPRING_BOOT}/clientes/excluir/${req.params.id}`);
    console.log('Usuario excluido do sistema com sucesso ', req.params)
    res.redirect('/');
  }catch(error){
    console.error('Erro ao excluir cliente: ', error.message);
    res.render('error', {message: 'Erro ao excluir cliente'});
  }
})

app.listen(3000, () => {
  console.log('Servidor rodando em http://localhost:3000');
});
