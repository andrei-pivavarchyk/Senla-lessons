# Angular Universal starter kit

Репозиторий с Angular CLI и Angular Universal

- http://master-ssr.gorniv.com/ - серверный рендеринг master

- http://master-csr.gorniv.com/ - клиенский рендеринг master

## Как запустить
- `npm install`
- `npm run start` - для клиенского рендеринга
- `npm run ssr` -  для серверного рендеринга
- `npm run build:universal` - для сборки в релиз
- `npm run server` - для запуска сервера
- `npm run build:prerender` - для генерации статики по `static.paths.ts`
- как запустить watch: один раз: `npm run ssr:cw`, один раз: `npm run ssr:sw`, после каждого изменения: `npm run ssr:server`

## Полезные ссылки
- [Официальная документация](https://angular.io/)
- [Все команды Angular CLI и их назначение](https://dev.nvx.me/angular-cli-ref/)
- [Angular Material2](https://material.angular.io/)
- [PrimeNg](https://www.primefaces.org/primeng/)
- [ionic](https://ionic.io/)

## Структура проекта

### Директория src
- **app/app.component.{ts,html,css,spec.ts}** — специфицирует AppComponent компонент html-шаблоном, стилями и юнит-тестами. Это корневой компонент, для которого по мере развития приложения появится дерево вложенных компонентов.
- **app/app.module.ts** — специфицирует AppModule. Корневой модуль, который сообщает Angular, как будет собрано приложение. Сейчас в нем объявлен только AppComponent. Впоследствии вы будете объявлять в нем другие компоненты.
- **assets/** — директория, в которой вы размещаете изображения и все остальное, которую необходимо скопировать в конечную директорию сборки, когда вы создадите непосредственно само приложение.
- **environments/** — эта директория содержит файлы целей сборки (dev или prod режимы), каждый из которых экспортирует простые env-переменные конфигурации, необходимые для использования в вашем приложении. Когда вы разрабатываете приложение, файлы собираются «на лету». Вы можете использовать разный набор API при разработке (dev), отличный от продакшина (prod), у которого вы можете подключать всякие метрики или auth-токены. Вы даже можете использовать разные сервисы или заглушки при разных целях сборки.
- **favicon.ico** — вы можете добавить свою собственную иконку, которая будет отображаться на вкладке в браузере.
- **index.html** — основная HTML-страница, которая отображается, когда кто-то посещает ваш сайт. В большинстве случаев вам никогда не понадобится его редактировать. Angular CLI автоматически добавляет все сгенерированные js и css-файлы при создании вашего приложения, поэтому вам не нужно добавлять какие-либо теги (script, link) вручную.
- **main.ts** — точка входа вашего приложения. Сейчас, по умолчанию, ваше приложение компилируется в поставке с JIT-компилятором. Данный файл загружает корневой модуль приложения (AppModule) и запускает его в браузере. Вы также можете использовать AOT-компилятор, заранее скомпилировав свое приложение, исключив JIT-компилятор из сборки, для этого вы должны использовать флаг —aot для команд Angular CLI ng build и ng serve.
- **polyfills.ts** — различные браузеры имеют различные уровни поддержки тех или иных веб-стандартов. Полифиллы помогают нормализовать эти различия. Однако не забывайте проверять текущую поддержку браузерами.
- **styles.css** — здесь хранятся глобальные стили. Большую часть времени вы будете работать с локальными стилями своих компонентов, но стили, которые влияют на все ваше приложение, должны находиться в этом месте.
- **test.ts** — это точка входа всех ваших юнит-тестов. Этот файл имеет настраиваемую конфигурацию, но, как правило, вы будете редко его править.
- **tsconfig.{app|spec}.json** — конфигурация компилятора TypeScript описывается в файле tsconfig.app.json, для юнит-тестов же используется конфигурация tsconfig.spec.json.

### Корневая директория проекта
- **e2e/** — внутри директории e2e/ располагаются e2e (end-to-end) тесты. Они не должны находиться внутри директории src/, поскольку эти тесты представляют собой отдельное приложение, которое тестирует ваше основное приложение. Внутри располагаются конфигурационные файлы, например, tsconfig.e2e.json.
- **node_modules/** — Node.js создает данную директорию, в которой хранит все сторонние модули, перечисленные в package.json.
- **.angular-cli.json** — конфигурационный файл Angular CLI. В этом файле вы можете установить несколько значений по умолчанию, а также настроить, какие файлы будут включены при сборке проекта.
- **.editorconfig** — Простая настройка для вашего редактора, специфицирующая одинаковую базовую конфигурацию для форматирования текста кода. Большинство редакторов поддерживают файл .editorconfig. Дополнительную информацию смотрите на странице http://editorconfig.org.
- **.gitignore** — это файл необходим для системы контроля версий, он нужен, чтобы исключить автосгенерированные файлы, которые не нужно хранить в Git-репозитории.
- **karma.conf.js** — конфигурационный файл для запуска юнит-тестов с использованием Karma, запуск тестов можно выполнить командой ng test.
- **package.json** — конфигурационный файл npm, в нем перечисляются сторонние модули (пакеты) разработчиков, которые использует ваш проект. Здесь вы также можете прописать и свои собственные скрипты.
- **tsconfig.json** — конфигурация компилятора TypeScript для вашей IDE.
- **tslint.json** — конфигурация для статического анализатора TSLint, используется при запуске ng lint. Для чего нужен анализатор вы можете посмотрев на пример.

## Как использовать этот репозиторий в своем проекте:
Для переноса ssr в свой репозиторий вам необходимы файлы:
- .angular-cli.json
- server.ts
- prerender.ts
- webpack.config.js
- main.server.ts
- main.browser.ts
- modules/*
- forStorage/*
- environments/*
- app.browser.module.ts
- app.server.module.ts 

## Ссылки
- Официальный пример на анлийиском: https://github.com/angular/universal-starter 
- Официальный пример на русском: https://github.com/Angular-RU/angular-universal-starter

## Используемые модули
- https://github.com/angular/universal/tree/master/modules/aspnetcore-engine -движок для .net core
- https://github.com/angular/universal/tree/master/modules/common - TransferHttpCacheModule, на данный момент мной не используется, если знаете куда и зачем его встаить - напишите мне или в issue, pull request
- https://github.com/angular/universal/tree/master/modules/express-engine - Express Engine для запуска рендеринга в node, в нашем приложении используется. Обратите внимание, что актуальная версия  не ниже 5.0.0-beta.5
- https://github.com/angular/universal/tree/master/modules/hapi-engine -  Hapi Engine альтернативный движок для рендеринга. В примере не используется, принципиально в схеме подключения не отличается от express-engine
- https://github.com/angular/universal/tree/master/modules/module-map-ngfactory-loader - модуль поиска модулей для LazyLoading - вещь нужная и  используемая. Обратите внимание, что актуальная версия  не ниже 5.0.0-beta.5

## Особенности(Важно)
- модуль для TransferHttp  использует `import { TransferState } from '@angular/platform-browser';` и необходим для реализации запроса rest api  на сервере и остутствия повторного запроса второй раз. Смотрите `home.component.ts` (задержка 3с)

- для работы preboot в `tsconfig.json` добавить
```json
  "include": [
    "src/**/*",
    "node_modules/preboot/browser.ts"
  ],
```

```ts
this.http.get('https://reqres.in/api/users?delay=3').subscribe(result => {
    this.result = result;
});
```
- `export const AppRoutes = RouterModule.forRoot(routes, { initialNavigation: 'enabled' });` -  чтобы не было мигания страницы!

- для работы с куками написан `AppStorage`,  которыйй при помощи DI  позволяет отдавать разную реализацию для сервера и бразуера. Смотрите `server.storage.ts` и `browser.storage.ts` по реализациям. В `server.ts`  есть 
```ts
providers: [
    {
        provide: REQUEST, useValue: (req)
    },
    {
        provide: RESPONSE, useValue: (res)
    }
]
```
для работы с REQUEST и RESPONSE через DI -  это необходимо для реализации UniversalStorage при работе с cookies.

- webpack.config.js  прописан исключительно для сборки файла server.ts в  server.js, так как angular-cliт имеет [баг](https://github.com/angular/angular-cli/issues/7200) для работы с 3d зависимостями.
- для решения части проблем используется следущий код в `server.ts`

Решение проблем глобавльных переменных, в том числе `document is not defined` и `window is not defined`
```ts
const domino = require('domino');
const fs = require('fs');
const path = require('path');
const template = fs.readFileSync(path.join(__dirname, '.', 'dist', 'index.html')).toString();
const win = domino.createWindow(template);
const files = fs.readdirSync(`${process.cwd()}/dist-server`);
const styleFiles = files.filter(file => file.startsWith('styles'));
const hashStyle = styleFiles[0].split('.')[1];
const style = fs.readFileSync(path.join(__dirname, '.', 'dist-server', `styles.${hashStyle}.bundle.css`)).toString();

global['window'] = win;
Object.defineProperty(win.document.body.style, 'transform', {
  value: () => {
    return {
      enumerable: true,
      configurable: true
    };
  },
});
global['document'] = win.document;
global['CSS'] = style;
// global['XMLHttpRequest'] = require('xmlhttprequest').XMLHttpRequest;
global['Prism'] = null;

```

```ts
global['navigator'] = req['headers']['user-agent'];
```
это позволяет убрать часть проблем при работе с `undefined`.

# Планы:
- [x] Angular 5
- [x] `document is not defined` и `window is not defined` - [тут](./defined.md)
- [x] [Angular Material2](https://material.angular.io/) **UI компоненты** - [отдельная ветка](https://git.senla.eu/SergeiYakimchik/angular-universal-starter/tree/material2)
- [x] [Primeng](https://www.primefaces.org/primeng/) **UI компоненты** - [отдельная ветка](https://git.senla.eu/SergeiYakimchik/angular-universal-starter/tree/primeng)
- [x] импорт модулей в зависимости от платформы (`MockServerBrowserModule`)
- [x] выполнение запросов к api на сервере `TransferHttp`
- [x] работа с Cookies на сервере `UniversalStorage`
- [x] Uses **[ngx-meta](https://github.com/fulls1z3/ngx-meta)** для SEO (*title, meta tags, and Open Graph tags for social sharing*).
- [x] используется ngx-translate для поддержки интернационализации (i18n)
- [x] используется ORIGIN_URL - для абсолютных запросов
- [ ] @angular/service-worker
- [ ] Ionic - необходимо собрать веб версию, пока есть проблемы [отдельная ветка](https://git.senla.eu/SergeiYakimchik/angular-universal-starter/tree/ionic)